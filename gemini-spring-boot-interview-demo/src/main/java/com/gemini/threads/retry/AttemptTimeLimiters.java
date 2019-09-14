package com.gemini.threads.retry;

import com.github.rholder.retry.AttemptTimeLimiter;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.retry
 * @classname: AttemptTimeLimiters
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/12 18:22
 * @since 1.0.0
 */
public class AttemptTimeLimiters {
    private AttemptTimeLimiters() {
    }

    public static <V> AttemptTimeLimiter<V> noTimeLimit() {
        return new com.gemini.threads.retry.AttemptTimeLimiters.NoAttemptTimeLimit();
    }

//    public static <V> AttemptTimeLimiter<V> fixedTimeLimit(long duration, @Nonnull TimeUnit timeUnit) {
//        Preconditions.checkNotNull(timeUnit);
//        return new com.gemini.threads.retry.AttemptTimeLimiters.FixedAttemptTimeLimit(duration, timeUnit);
//    }

    public static <V> AttemptTimeLimiter<V> fixedTimeLimit(long duration, @Nonnull TimeUnit timeUnit, @Nonnull ExecutorService executorService) {
        Preconditions.checkNotNull(timeUnit);
        return new com.gemini.threads.retry.AttemptTimeLimiters.FixedAttemptTimeLimit(duration, timeUnit, executorService);
    }

    @Immutable
    private static final class FixedAttemptTimeLimit<V> implements AttemptTimeLimiter<V> {
        private final TimeLimiter timeLimiter;
        private final long duration;
        private final TimeUnit timeUnit;

//        public FixedAttemptTimeLimit(long duration, @Nonnull TimeUnit timeUnit) {
//            this(new SimpleTimeLimiter(), duration, timeUnit);
//        }

        public FixedAttemptTimeLimit(long duration, @Nonnull TimeUnit timeUnit, @Nonnull ExecutorService executorService) {
            this(SimpleTimeLimiter.create(executorService), duration, timeUnit);
        }

        private FixedAttemptTimeLimit(@Nonnull TimeLimiter timeLimiter, long duration, @Nonnull TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeLimiter);
            Preconditions.checkNotNull(timeUnit);
            this.timeLimiter = timeLimiter;
            this.duration = duration;
            this.timeUnit = timeUnit;
        }


        @Override
        public V call(Callable<V> callable) throws Exception {
            return this.timeLimiter.callWithTimeout(callable, this.duration, this.timeUnit);
        }
    }

    @Immutable
    private static final class NoAttemptTimeLimit<V> implements AttemptTimeLimiter<V> {
        private NoAttemptTimeLimit() {
        }

        @Override
        public V call(Callable<V> callable) throws Exception {
            return callable.call();
        }
    }
}
