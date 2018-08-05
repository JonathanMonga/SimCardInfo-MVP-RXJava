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

package com.jonathan.simcardinfo.views.simcard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jonathan.simcardinfo.BaseFragment;
import com.jonathan.simcardinfo.R;
import com.jonathan.simcardinfo.models.domain.SimCardEntry;
import com.jonathan.simcardinfo.presenter.SimCardPresenter;

import butterknife.BindView;

public class SimCardInfoFragment extends BaseFragment<SimCardPresenter, SimCardView> implements SimCardView {

    @BindView(R.id.TV_SIM_CONTRY_ISO)
    TextView TV_SIM_CONTRY_ISO;
    @BindView(R.id.TV_NETWORK_OPERATOR_NAME)
    TextView TV_NETWORK_OPERATOR_NAME;
    @BindView(R.id.TV_SIM_OPERATOR_NAME)
    TextView TV_SIM_OPERATOR_NAME;
    @BindView(R.id.TV_NETWORK_ROAMING)
    TextView TV_NETWORK_ROAMING;
    @BindView(R.id.TV_DEVICE_ID)
    TextView TV_DEVICE_ID;
    @BindView(R.id.TV_VOICE_MAIL_ALPHA_TAG)
    TextView TV_VOICE_MAIL_ALPHA_TAG;
    @BindView(R.id.TV_DEVICE_SOFTWARE_VERSION)
    TextView TV_DEVICE_SOFTWARE_VERSION;
    @BindView(R.id.TV_SIM_SERIAL_NUMBER)
    TextView TV_SIM_SERIAL_NUMBER;

    private SimCardEntry simCardEntry;

    public SimCardInfoFragment() {
    }

    public static SimCardInfoFragment newInstance() {
        SimCardInfoFragment fragment = new SimCardInfoFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            simCardEntry = savedInstanceState.getParcelable(PARCELABLE_ENTRY);
            initViews();
        } else {
            getPresenter().loadSimCardEntry();
        }
    }
    
    private void initViews(){
        TV_SIM_CONTRY_ISO.setText(simCardEntry.SIM_CONTRY_ISO);
        TV_DEVICE_ID.setText(simCardEntry.DEVICE_ID);
        TV_DEVICE_SOFTWARE_VERSION.setText(simCardEntry.DEVICE_SOFTWARE_VERSION);
        TV_NETWORK_OPERATOR_NAME.setText(simCardEntry.NETWORK_OPERATOR_NAME);
        TV_NETWORK_ROAMING.setText(String.valueOf(simCardEntry.NETWORK_ROAMING));
        TV_SIM_OPERATOR_NAME.setText(simCardEntry.SIM_OPERATOR_NAME);
        TV_SIM_SERIAL_NUMBER.setText(simCardEntry.SIM_SERIAL_NUMBER);
        TV_VOICE_MAIL_ALPHA_TAG.setText(simCardEntry.VOICE_MAIL_ALPHA_TAG);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(PARCELABLE_ENTRY, simCardEntry);
        super.onSaveInstanceState(outState);
    }

    @Override
    public int setLayout() {
        return R.layout.sim_info_fragment;
    }

    @NonNull
    @Override
    public SimCardPresenter providePresenter() {
        return new SimCardPresenter();
    }

    @Override
    public void showSimCardEntry(SimCardEntry simCardEntry) {
        this.simCardEntry = simCardEntry;
        initViews();
    }
}

