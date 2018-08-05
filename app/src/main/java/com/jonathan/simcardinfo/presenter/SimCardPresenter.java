/*
 * Copyright (c) 2018 Jonathan Monga <jmonga98@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jonathan.simcardinfo.presenter;

import com.jonathan.simcardinfo.models.DataManager;
import com.jonathan.simcardinfo.models.domain.SimCardEntry;
import com.jonathan.simcardinfo.utils.RxSchedulerUtil;
import com.jonathan.simcardinfo.views.simcard.SimCardView;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx2.RxTiPresenterDisposableHandler;

import io.reactivex.functions.Consumer;

public class SimCardPresenter extends TiPresenter<SimCardView> {
    private RxTiPresenterDisposableHandler disposableHandler = new RxTiPresenterDisposableHandler(this);
    private DataManager dataManager;

    @Override
    protected void onCreate() {
        super.onCreate();
        dataManager = DataManager.getInstance();
    }

    public void loadSimCardEntry() {
        disposableHandler.manageDisposable(dataManager.getSimCardEntryObservable()
                .compose(RxSchedulerUtil.<SimCardEntry>applyObservableAsync())
                .doOnNext(new Consumer<SimCardEntry>() {
                    @Override
                    public void accept(SimCardEntry simCardEntry) {
                        getView().showSimCardEntry(simCardEntry);
                    }
                }).subscribe()
        );
    }
}
