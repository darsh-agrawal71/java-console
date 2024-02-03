package lib.services;

import lib.util.ItemBoxer;

public interface ServiceCallback<T> {
    static <T> ServiceCallback<T> nothing() {
        return new ServiceCallback<T>() {
            @Override
            public void onSuccess(T result) {
            }
            @Override
            public void onFailure(Exception e) {
            }
        };
    }

    static <T> ServiceCallback<T> successful(ItemBoxer<Boolean> box) {
        return new ServiceCallback<T>() {
            @Override
            public void onSuccess(T result) {
                box.setValue(true);
            }

            @Override
            public void onFailure(Exception e) {
                box.setValue(false);
            }
        };
    }
    void onSuccess(T result);
    void onFailure(Exception e);
}
