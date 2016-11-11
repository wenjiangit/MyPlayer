package com.douliu.myplayer.utils;

import android.text.TextUtils;

import com.douliu.myplayer.api.ApiException;
import com.douliu.myplayer.bean.VideoHttpResponse;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by douliu on 2016/11/11.
 */
public class RxUtil {

    /**
     * 返回结果统一处理
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<VideoHttpResponse<T>,T> handleResult(){
        return videoHttpResponseObservable -> videoHttpResponseObservable
                .flatMap((Func1<VideoHttpResponse<T>, Observable<T>>) tVideoHttpResponse -> {
            if (tVideoHttpResponse.getCode()==200){
                return createData(tVideoHttpResponse.getRet());
            }else if (!TextUtils.isEmpty(tVideoHttpResponse.getMsg())){
                return Observable.error(new ApiException(tVideoHttpResponse.getMsg()));
            }else {
                return Observable.error(new ApiException("服务器返回异常~~~"));
            }
        });
    }

    public static <T> Observable<T> createData(T t){
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }
}
