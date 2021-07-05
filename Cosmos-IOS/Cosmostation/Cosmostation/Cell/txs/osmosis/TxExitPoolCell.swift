//
//  TxExitPoolCell.swift
//  Cosmostation
//
//  Created by yongjoo jung on 2021/07/04.
//  Copyright © 2021 wannabit. All rights reserved.
//

import UIKit

class TxExitPoolCell: TxCell {
    
    @IBOutlet weak var txIcon: UIImageView!
    @IBOutlet weak var txSenderLabel: UILabel!
    @IBOutlet weak var txPoolIdLabel: UILabel!
    @IBOutlet weak var txPoolShareInAmountLabel: UILabel!
    @IBOutlet weak var txPoolAsset1AmountLabel: UILabel!
    @IBOutlet weak var txPoolAsset1DenomLabel: UILabel!
    @IBOutlet weak var txPoolAsset2AmountLabel: UILabel!
    @IBOutlet weak var txPoolAsset2DenomLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        self.selectionStyle = .none
        
        txPoolAsset1AmountLabel.font = UIFontMetrics(forTextStyle: .caption1).scaledFont(for: Font_12_caption1)
        txPoolAsset2AmountLabel.font = UIFontMetrics(forTextStyle: .caption1).scaledFont(for: Font_12_caption1)
    }
    
    override func onBindMsg(_ chain: ChainType, _ response: Cosmos_Tx_V1beta1_GetTxResponse, _ position: Int) {
        txIcon.image = txIcon.image?.withRenderingMode(.alwaysTemplate)
        txIcon.tintColor = WUtils.getChainColor(chain)
        
        let msg = try! Osmosis_Gamm_V1beta1_MsgExitPool.init(serializedData: response.tx.body.messages[position].value)
        txSenderLabel.text = msg.sender
        txSenderLabel.adjustsFontSizeToFitWidth = true
        
        txPoolIdLabel.text = String(msg.poolID)
        
        txPoolShareInAmountLabel.text = NSDecimalNumber.init(string: msg.shareInAmount).multiplying(byPowerOf10: -18).rounding(accordingToBehavior: WUtils.handler18).stringValue
        
        let coin0 = Coin.init(msg.tokenOutMins[0].denom, msg.tokenOutMins[0].amount)
        let coin1 = Coin.init(msg.tokenOutMins[1].denom, msg.tokenOutMins[1].amount)
        
        WUtils.showCoinDp(coin0, txPoolAsset1DenomLabel, txPoolAsset1AmountLabel, chain)
        WUtils.showCoinDp(coin1, txPoolAsset2DenomLabel, txPoolAsset2AmountLabel, chain)
    }
    
}
