//
//  WalletBnbCell.swift
//  Cosmostation
//
//  Created by yongjoo on 27/09/2019.
//  Copyright © 2019 wannabit. All rights reserved.
//

import UIKit

class WalletBnbCell: UITableViewCell {
    
    @IBOutlet weak var totalAmount: UILabel!
    @IBOutlet weak var totalValue: UILabel!
    @IBOutlet weak var availableAmount: UILabel!
    @IBOutlet weak var lockedAmount: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        self.selectionStyle = .none
    }
    
    var actionWC: (() -> Void)? = nil
    
    @IBAction func onClickWC(_ sender: Any) {
        actionWC?()
    }
}
