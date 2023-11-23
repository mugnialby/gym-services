package com.alby.gymservices.util;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class Constant {

    public static class SUBSCRIPTION_STATUS {
        public static final Long ACTIVE_ID = 1L;

        public static final Long CANCEL_ID = 2L;

        public static final Long EXPIRED_ID = 3L;
    }

    public static class PAYMENT_STATUS {
        public static final Long DONE_ID = 1L;

        public static final Long OUTSTANDING_ID = 2L;

        public static final Long PROCESSED_ID = 3L;
    }
}
