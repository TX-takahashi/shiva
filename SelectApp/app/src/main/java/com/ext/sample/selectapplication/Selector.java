package com.ext.sample.selectapplication;


public interface Selector {

    interface Listener {
        void onTypeChanged(String result);
    }

    /**
     * Initialize Selector instance.
     */
    void execute();

    /**
     * Select according to Selector instance.
     */
    void select();


    /**
     * Register callback listener.
     *
     * @param listener SelectListener
     */
    void registerListener(Selector.Listener listener);

    /**
     * Unregister callback listener.
     */
    void unregisterListener();
}
