package co.zero.model;

public enum WizardState {
    RETRIEVING_INFO() {
        @Override
        public WizardState next() {
            return ON_VALIDATION;
        }
    },
    ON_VALIDATION() {
        @Override
        public WizardState next() {
            return ON_CARRIER;
        }
    },
    ON_CARRIER() {
        @Override
        public WizardState next() {
            return ON_CARRIER_TEST;
        }
    },
    ON_CARRIER_TEST() {
        @Override
        public WizardState next() {
            return ON_INTERNAL_TEST;
        }
    },
    ON_INTERNAL_TEST() {
        @Override
        public WizardState next() {
            return LIVE;
        }
    },
    LIVE() {
        @Override
        public WizardState next() {
            return LIVE;
        }

        @Override
        public boolean isFinal() {
            return true;
        }
    };

    public abstract WizardState next();

    public boolean isFinal() {
        return false;
    }
}
