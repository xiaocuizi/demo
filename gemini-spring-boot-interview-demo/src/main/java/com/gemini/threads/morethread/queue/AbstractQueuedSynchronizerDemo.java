package com.gemini.threads.morethread.queue;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.morethread.queue
 * @classname: AbstractQueuedSynchronizerDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/4/15 13:10
 * @since 1.0.0
 */
public class AbstractQueuedSynchronizerDemo extends AbstractQueuedSynchronizer {

    static final int SHARED_SHIFT   = 16;
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;

    public static void main(String[] args) {


        System.out.println("MAX_COUNT="+MAX_COUNT);

        /*AbstractQueuedSynchronizerDemo aqs = new AbstractQueuedSynchronizerDemo();
        boolean tryAcquire = aqs.tryAcquire(1);
        System.out.println(tryAcquire);*/

    }


    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    /**
     * Attempts to set the state to reflect a release in shared mode.
     *
     * <p>This method is always invoked by the thread performing release.
     *
     * <p>The default implementation throws
     * {@link UnsupportedOperationException}.
     *
     * @param arg the release argument. This value is always the one
     *            passed to a release method, or the current state value upon
     *            entry to a condition wait.  The value is otherwise
     *            uninterpreted and can represent anything you like.
     * @return {@code true} if this release of shared mode may permit a
     * waiting acquire (shared or exclusive) to succeed; and
     * {@code false} otherwise
     * @throws IllegalMonitorStateException  if releasing would place this
     *                                       synchronizer in an illegal state. This exception must be
     *                                       thrown in a consistent fashion for synchronization to work
     *                                       correctly.
     * @throws UnsupportedOperationException if shared mode is not supported
     */
    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }
}
