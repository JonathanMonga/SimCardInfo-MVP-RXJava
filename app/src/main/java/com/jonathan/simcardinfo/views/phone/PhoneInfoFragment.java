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

package com.jonathan.simcardinfo.views.phone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jonathan.simcardinfo.BaseFragment;
import com.jonathan.simcardinfo.R;
import com.jonathan.simcardinfo.models.domain.PhoneEntry;
import com.jonathan.simcardinfo.presenter.PhonePresenter;

import butterknife.BindView;

public class PhoneInfoFragment extends BaseFragment<PhonePresenter, PhoneView> implements PhoneView {

    @BindView(R.id.TV_BOARD)
    TextView TV_BOARD;
    @BindView(R.id.TV_BOOTLOADER)
    TextView TV_BOOTLOADER;
    @BindView(R.id.TV_BRAND)
    TextView TV_BRAND;
    @BindView(R.id.TV_CPU_ABI)
    TextView TV_CPU_ABI;
    @BindView(R.id.TV_CPU_ABI2)
    TextView TV_CPU_ABI2;
    @BindView(R.id.TV_DEVICE)
    TextView TV_DEVICE;
    @BindView(R.id.TV_DISPLAY)
    TextView TV_DISPLAY;
    @BindView(R.id.TV_FINGERPRINT)
    TextView TV_FINGERPRINT;
    @BindView(R.id.TV_HARDWARE)
    TextView TV_HARDWARE;
    @BindView(R.id.TV_HOST)
    TextView TV_HOST;
    @BindView(R.id.TV_ID)
    TextView TV_ID;
    @BindView(R.id.TV_MANUFACTURER)
    TextView TV_MANUFACTURER;
    @BindView(R.id.TV_MODEL)
    TextView TV_MODEL;
    @BindView(R.id.TV_PRODUCT)
    TextView TV_PRODUCT;
    @BindView(R.id.TV_SERIAL)
    TextView TV_SERIAL;
    @BindView(R.id.TV_TAGS)
    TextView TV_TAGS;
    @BindView(R.id.TV_TYPE)
    TextView TV_TYPE;
    @BindView(R.id.TV_USER)
    TextView TV_USER;
    @BindView(R.id.TV_CODENAME)
    TextView TV_CODENAME;
    @BindView(R.id.TV_INCREMENTAL)
    TextView TV_INCREMENTAL;
    @BindView(R.id.TV_RELEASE)
    TextView TV_RELEASE;
    @BindView(R.id.TV_SDK_INT)
    TextView TV_SDK_INT;
    @BindView(R.id.TV_RADIO_VERSION)
    TextView TV_RADIO_VERSION;

    private PhoneEntry phoneEntry;

    public PhoneInfoFragment() {
    }

    public static PhoneInfoFragment newInstance() {
        PhoneInfoFragment fragment = new PhoneInfoFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            phoneEntry = savedInstanceState.getParcelable(PARCELABLE_ENTRY);
            initViews();
        } else
            getPresenter().loadPhoneEntry();
    }

    private void initViews(){
        TV_BOARD.setText(phoneEntry.BOARD);
        TV_BOOTLOADER.setText(phoneEntry.BOOTLOADER);
        TV_BRAND.setText(phoneEntry.BRAND);
        TV_CPU_ABI.setText(phoneEntry.CPU_ABI);
        TV_CPU_ABI2.setText(phoneEntry.CPU_ABI2);
        TV_DEVICE.setText(phoneEntry.DEVICE);
        TV_DISPLAY.setText(phoneEntry.DISPLAY);
        TV_FINGERPRINT.setText(phoneEntry.FINGERPRINT);
        TV_HARDWARE.setText(phoneEntry.HARDWARE);
        TV_HOST.setText(phoneEntry.HOST);
        TV_ID.setText(phoneEntry.ID);
        TV_MANUFACTURER.setText(phoneEntry.MANUFACTURER);
        TV_MODEL.setText(phoneEntry.MODEL);
        TV_PRODUCT.setText(phoneEntry.PRODUCT);
        TV_SERIAL.setText(phoneEntry.SERIAL);
        TV_TAGS.setText(phoneEntry.TAGS);
        TV_TYPE.setText(phoneEntry.TYPE);
        TV_USER.setText(phoneEntry.USER);
        TV_CODENAME.setText(phoneEntry.CODENAME);
        TV_INCREMENTAL.setText(phoneEntry.INCREMENTAL);
        TV_RELEASE.setText(phoneEntry.RELEASE);
        TV_SDK_INT.setText(phoneEntry.SDK_INT);
        TV_RADIO_VERSION.setText(phoneEntry.RADIO_VERSION);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(PARCELABLE_ENTRY, phoneEntry);
        super.onSaveInstanceState(outState);
    }

    @Override
    public int setLayout() {
        return R.layout.build_info_fragment;
    }

    @Override
    public void showPhoneEntry(PhoneEntry phoneEntry) {
        this.phoneEntry = phoneEntry;
        initViews();
    }

    @NonNull
    @Override
    public PhonePresenter providePresenter() {
        return new PhonePresenter();
    }
}

