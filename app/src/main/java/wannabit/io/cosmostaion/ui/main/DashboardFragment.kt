package wannabit.io.cosmostaion.ui.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import wannabit.io.cosmostaion.R
import wannabit.io.cosmostaion.chain.CosmosLine
import wannabit.io.cosmostaion.common.BaseData
import wannabit.io.cosmostaion.common.formatAssetValue
import wannabit.io.cosmostaion.database.model.BaseAccount
import wannabit.io.cosmostaion.databinding.FragmentDashboardBinding
import wannabit.io.cosmostaion.ui.main.chain.CosmosDetailFragment
import wannabit.io.cosmostaion.ui.main.edit.ChainEditFragment
import java.math.BigDecimal


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding: FragmentDashboardBinding? get() = _binding

    private lateinit var dashAdapter: DashboardAdapter

    private var baseAccount: BaseAccount? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickAction()
    }

    override fun onResume() {
        super.onResume()
        Log.e("baseAccount : ", baseAccount.toString())
        var needFetch = false
        if (baseAccount == null) {
            needFetch = true
        }

        if (needFetch) {
            initView()
            initRecyclerView()
            onUpdateLoadData()
        }
    }

    private fun initView() {
        baseAccount = BaseData.baseAccount
        baseAccount?.initDisplayData()
        binding?.apply {
            accountName.text = baseAccount?.name
        }
    }

    private fun initRecyclerView() {
        baseAccount?.let { baseAccount ->
            dashAdapter = DashboardAdapter(requireContext(), baseAccount)

            binding?.recycler?.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = dashAdapter
                dashAdapter.submitList(baseAccount.displayCosmosLineChains as List<Any>?)

                var isClickable = true
                dashAdapter.setOnItemClickListener {
                    if (isClickable) {
                        isClickable = false

                        val bundle = Bundle()
                        bundle.putInt("selectPosition", it)
                        val fragment = CosmosDetailFragment()
                        fragment.arguments = bundle

                        requireActivity().supportFragmentManager.beginTransaction()
                            .setCustomAnimations(R.animator.to_right, R.animator.from_right, R.animator.to_left, R.animator.from_left)
                            .add(R.id.fragment_container, fragment)
                            .hide(this@DashboardFragment)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commitAllowingStateLoss()

                        (activity as MainActivity?)?.onNextHideBottomNavi()

                        Handler().postDelayed({
                            isClickable = true
                        }, 1000)
                    }
                }
            }
        }
    }

    private fun onUpdateLoadData() {
        baseAccount?.let {
            it.displayCosmosLineChains.forEach { line ->
                line.setLoadDataCallBack(object : CosmosLine.LoadDataCallback {
                    override fun onDataLoaded(isLoaded: Boolean) {
                        lifecycleScope.launch {
                            withContext(Dispatchers.Main) {
                                if (line.fetched) {
                                    dashAdapter.notifyDataSetChanged()
                                    onUpdateTotal()
                                }
                            }
                        }
                    }
                })
            }
            onUpdateTotal()
        }
    }

    private fun onUpdateTotal() {
        var sum = BigDecimal.ZERO
        baseAccount?.let {
            it.displayCosmosLineChains.forEach { line ->
                sum = sum.add(line.allAssetValue())
            }
            if (isAdded) {
                requireActivity().runOnUiThread {
                    binding?.totalValue?.text = formatAssetValue(sum)
                }
            }
        }
    }

    private fun clickAction() {
        var isClickable = true
        binding?.btnEdit?.setOnClickListener {
            val bottomSheet = ChainEditFragment()
            if (isClickable) {
                isClickable = false
                bottomSheet.show(parentFragmentManager, ChainEditFragment::class.java.name)

                Handler().postDelayed({
                    isClickable = true
                }, 1000)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}