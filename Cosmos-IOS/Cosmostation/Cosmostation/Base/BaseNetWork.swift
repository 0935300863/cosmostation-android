//
//  BaseNetWork.swift
//  Cosmostation
//
//  Created by 정용주 on 2020/12/09.
//  Copyright © 2020 wannabit. All rights reserved.
//

import Foundation
import GRPC
import NIO


class BaseNetWork {
    
    /*
    static func validatorUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_VALIDATORS
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_VALIDATORS
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_VALIDATORS
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_VALIDATORS
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_VALIDATORS
        }
        return result
    }
    
    static func delegationUrl(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_DELEGATIONS + address
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_DELEGATIONS + address
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_DELEGATIONS + address
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_DELEGATIONS + address
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_DELEGATIONS + address
        }
        return result
    }
    
    static func undelegationUrl(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_UNDELEGATIONS + address + COSMOS_MAIN_UNDELEGATIONS_T
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_UNDELEGATIONS + address + IRIS_MAIN_UNDELEGATIONS_T
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_UNDELEGATIONS + address + AKASH_MAIN_UNDELEGATIONS_T
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_UNDELEGATIONS + address + COSMOS_TEST_UNDELEGATIONS_T
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_UNDELEGATIONS + address + IRIS_TEST_UNDELEGATIONS_T
        }
        return result
    }
    
    static func balanceUrl(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_BALANCE + address
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_BALANCE + address
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_BALANCE + address
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_BALANCE + address
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_BALANCE + address
        }
        return result
    }
    
    static func authUrl(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_AUTH + address
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_AUTH + address
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_AUTH + address
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_AUTH + address
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_AUTH + address
        }
        return result
    }
    
    static func rewardAddressUrl(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_REWARD_ADDRESS + address + COSMOS_MAIN_REWARD_ADDRESS_T
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_REWARD_ADDRESS + address + IRIS_MAIN_REWARD_ADDRESS_T
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_REWARD_ADDRESS + address + AKASH_MAIN_REWARD_ADDRESS_T
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_REWARD_ADDRESS + address + COSMOS_TEST_REWARD_ADDRESS_T
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_REWARD_ADDRESS + address + IRIS_TEST_REWARD_ADDRESS_T
        }
        return result
    }
    
    static func rewardsUrl(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_REWARDS + address + COSMOS_MAIN_REWARDS_T
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_REWARDS + address + IRIS_MAIN_REWARDS_T
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_REWARDS + address + AKASH_MAIN_REWARDS_T
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_REWARDS + address + COSMOS_TEST_REWARDS_T
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_REWARDS + address + IRIS_TEST_REWARDS_T
        }
        return result
    }
    
    static func redelegation(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_REDELEGATION + address + COSMOS_MAIN_REDELEGATION_T
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_REDELEGATION + address + IRIS_MAIN_REDELEGATION
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_REDELEGATION + address + AKASH_MAIN_REDELEGATION_T
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_REDELEGATION + address + COSMOS_TEST_REDELEGATION_T
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_REDELEGATION + address + IRIS_TEST_REDELEGATION_T
        }
        return result
    }
    
    static func mintParamUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_MINT_PARAM
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_MINT_PARAM
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_MINT_PARAM
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_MINT_PARAM
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_MINT_PARAM
        }
        return result
    }
    
    static func inflationUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_INFLATION
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_INFLATION
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_INFLATION
        }
        return result
    }
    
    static func provisionUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_PROVISIONS
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_PROVISIONS
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_PROVISIONS
        }
        return result
    }
    
    static func stakingPoolUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_STAKING_POOL
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_STAKING_POOL
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_STAKING_POOL
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_STAKING_POOL
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_STAKING_POOL
        }
        return result
    }
    
    static func irisTokensUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_TOKENS
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_TOKENS
        }
        return result
    }
    
    
    
    static func singleValidatorUrl(_ chain: ChainType, _ opAddress: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_SINGLE_VALIDATOR + opAddress
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_SINGLE_VALIDATOR + opAddress
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_SINGLE_VALIDATOR + opAddress
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_SINGLE_VALIDATOR + opAddress
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_SINGLE_VALIDATOR + opAddress
        }
        return result
    }
    
    static func singleDelegationUrl(_ chain: ChainType, _ address: String, _ opAddress: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_SINGLE_DELEGATION + opAddress + COSMOS_MAIN_SINGLE_DELEGATION_M + address
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_SINGLE_DELEGATION + opAddress + IRIS_MAIN_SINGLE_DELEGATION_M + address
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_SINGLE_DELEGATION + opAddress + AKASH_MAIN_SINGLE_DELEGATION_M + address
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_SINGLE_DELEGATION + opAddress + COSMOS_TEST_SINGLE_DELEGATION_M + address
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_SINGLE_DELEGATION + opAddress + IRIS_TEST_SINGLE_DELEGATION_M + address
        }
        return result
    }
    
    static func proposals(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_PROPOSALS
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_PROPOSALS
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_PROPOSALS
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_PROPOSALS
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_PROPOSALS
        }
        return result
    }
    
    static func proposalDetail(_ chain: ChainType, _ proposal_id: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_PROPOSAL + proposal_id
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_PROPOSAL + proposal_id
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_PROPOSAL + proposal_id
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_PROPOSAL + proposal_id
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_PROPOSAL + proposal_id
        }
        return result
    }
    
    static func proposalTally(_ chain: ChainType, _ proposal_id: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_PROPOSAL + proposal_id + "/tally"
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_PROPOSAL + proposal_id + "/tally"
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_PROPOSAL + proposal_id + "/tally"
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_PROPOSAL + proposal_id + "/tally"
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_PROPOSAL + proposal_id + "/tally"
        }
        return result
    }
    
    static func proposalVoterList(_ chain: ChainType, _ proposal_id: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_PROPOSAL + proposal_id + "/votes"
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_PROPOSAL + proposal_id + "/votes"
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_PROPOSAL + proposal_id + "/votes"
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_PROPOSAL + proposal_id + "/votes"
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_PROPOSAL + proposal_id + "/votes"
        }
        return result
    }
    
    static func proposalMyVote(_ chain: ChainType, _ proposal_id: String, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_PROPOSAL + proposal_id + "/votes/" + address
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_PROPOSAL + proposal_id + "/votes/" + address
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_PROPOSAL + proposal_id + "/votes/" + address
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_PROPOSAL + proposal_id + "/votes/" + address
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_PROPOSAL + proposal_id + "/votes/" + address
        }
        return result
    }
    
    
    static func postTxUrl(_ chain: ChainType) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_BORAD_TX
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_BORAD_TX
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_BORAD_TX
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_BORAD_TX
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_BORAD_TX
        }
        return result
    }
     */
    
    
    static func accountHistory(_ chain: ChainType, _ address: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_HISTORY + address
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_HISTORY + address
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_HISTORY + address
        } else if (chain == ChainType.PERSIS_MAIN) {
            result = PERSIS_MAIN_HISTORY + address
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_HISTORY + address
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_HISTORY + address
        }
        return result
    }
    
    static func accountStakingHistory(_ chain: ChainType, _ address: String, _ valAddress: String) -> String {
        var result = ""
        if (chain == ChainType.COSMOS_MAIN) {
            result = COSMOS_MAIN_HISTORY + address + "/" + valAddress
        } else if (chain == ChainType.IRIS_MAIN) {
            result = IRIS_MAIN_HISTORY + address + "/" + valAddress
        } else if (chain == ChainType.AKASH_MAIN) {
            result = AKASH_MAIN_HISTORY + address + "/" + valAddress
        } else if (chain == ChainType.PERSIS_MAIN) {
            result = PERSIS_MAIN_HISTORY + address + "/" + valAddress
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            result = COSMOS_TEST_HISTORY + address + "/" + valAddress
        } else if (chain == ChainType.IRIS_TEST) {
            result = IRIS_TEST_HISTORY + address + "/" + valAddress
        }
        return result
    }
    
    
    
    
    
    
    
    static func getConnection(_ chain: ChainType, _ group: MultiThreadedEventLoopGroup) -> ClientConnection? {
        if (chain == ChainType.COSMOS_MAIN) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-cosmos-app.cosmostation.io", port: 9090)
            
        } else if (chain == ChainType.IRIS_MAIN) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-iris-app.cosmostation.io", port: 9090)
            
        } else if (chain == ChainType.AKASH_MAIN) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-akash-app.cosmostation.io", port: 9090)
            
        } else if (chain == ChainType.PERSIS_MAIN) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-persistence-app.cosmostation.io", port: 9090)
            
        } else if (chain == ChainType.CRYTO_MAIN) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-cryptocom.cosmostation.io", port: 9090)
        }
        
        else if (chain == ChainType.COSMOS_TEST) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-office.cosmostation.io", port: 9090)
            
        } else if (chain == ChainType.IRIS_TEST) {
            return ClientConnection.insecure(group: group).connect(host: "lcd-office.cosmostation.io", port: 9095)
            
        }
        return nil
    }
    
    static func getCallOptions() -> CallOptions {
        var callOptions = CallOptions()
        callOptions.timeLimit = TimeLimit.timeout(TimeAmount.milliseconds(8000))
        return callOptions
    }
    
}

