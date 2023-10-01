package com.gcash.controller.delivery;

public enum ParcelRuleFactory {
    Reject {
        @Override
        public DeliveryCostCalculator createRule() {
            return new Reject("Reject", 1);
        }
    },
    HeavyParcel {
        @Override
        public DeliveryCostCalculator createRule() {
            return new HeavyParcel("HeavyParcel", 2);
        }
    },
    SmallParcel {
        @Override
        public DeliveryCostCalculator createRule() {
            return new SmallParcel("SmallParcel", 3);
        }
    },
    MediumParcel {
        @Override
        public DeliveryCostCalculator createRule() {
            return new MediumParcel("MediumParcel", 4);
        }
    },
    LargeParcel {
        @Override
        public DeliveryCostCalculator createRule() {
            return new LargeParcel("LargeParcel", 5);
        }
    };

    public abstract DeliveryCostCalculator createRule();
}

