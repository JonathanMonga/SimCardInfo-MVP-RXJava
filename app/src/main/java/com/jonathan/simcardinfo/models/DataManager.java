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

package com.jonathan.simcardinfo.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.jonathan.simcardinfo.app.GlobalApplication;
import com.jonathan.simcardinfo.models.domain.PhoneEntry;
import com.jonathan.simcardinfo.models.domain.SimCardEntry;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class DataManager {
    public static final String TAG = DataManager.class.getSimpleName();
    
    private DataManager() {}
    
    public static DataManager getInstance(){
        return new DataManager();
    }

    public Observable<PhoneEntry> getPhoneEntryObservable() {
        return Observable.create(new ObservableOnSubscribe<PhoneEntry>() {
            @Override
            public void subscribe(ObservableEmitter<PhoneEntry> e) {
                PhoneEntry phoneEntry = new PhoneEntry();
                phoneEntry.BOARD = Build.BOARD;
                phoneEntry.BOOTLOADER = Build.BOOTLOADER;
                phoneEntry.BRAND = Build.BRAND;
                phoneEntry.CPU_ABI = Build.CPU_ABI;
                phoneEntry.CPU_ABI2 = Build.CPU_ABI2;
                phoneEntry.DEVICE = Build.DEVICE;
                phoneEntry.DISPLAY = Build.DISPLAY;
                phoneEntry.FINGERPRINT = Build.FINGERPRINT;
                phoneEntry.HARDWARE = Build.HARDWARE;
                phoneEntry.HOST = Build.HOST;
                phoneEntry.ID = Build.ID;
                phoneEntry.MANUFACTURER = Build.MANUFACTURER;
                phoneEntry.MODEL = Build.MODEL;
                phoneEntry.PRODUCT = Build.PRODUCT;
                phoneEntry.SERIAL = Build.SERIAL;
                phoneEntry.TAGS = Build.TAGS;
                phoneEntry.TYPE = Build.TYPE;
                phoneEntry.USER = Build.USER;
                phoneEntry.CODENAME = Build.VERSION.CODENAME;
                phoneEntry.INCREMENTAL = Build.VERSION.INCREMENTAL;
                phoneEntry.RELEASE = Build.VERSION.RELEASE;
                phoneEntry.SDK_INT = String.valueOf(Build.VERSION.SDK_INT);
                phoneEntry.RADIO_VERSION = Build.getRadioVersion();

                e.onNext(phoneEntry);
                e.onComplete();
            }
        });
    }

    @SuppressLint("MissingPermission")
    public Observable<SimCardEntry> getSimCardEntryObservable() {
        return Observable.create(new ObservableOnSubscribe<SimCardEntry>() {
            @Override
            public void subscribe(ObservableEmitter<SimCardEntry> e) {
                TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.getAppContext().getSystemService(Context.TELEPHONY_SERVICE);

                SimCardEntry simCardEntry = new SimCardEntry();
                simCardEntry.SIM_CONTRY_ISO = telephonyManager.getSimCountryIso();
                simCardEntry.NETWORK_OPERATOR_NAME = telephonyManager.getNetworkOperatorName();
                simCardEntry.SIM_OPERATOR_NAME = telephonyManager.getSimOperatorName();
                simCardEntry.NETWORK_ROAMING = telephonyManager.isNetworkRoaming();
                simCardEntry.DEVICE_ID = telephonyManager.getDeviceId();
                simCardEntry.VOICE_MAIL_ALPHA_TAG = telephonyManager.getVoiceMailAlphaTag();
                simCardEntry.DEVICE_SOFTWARE_VERSION = telephonyManager.getDeviceSoftwareVersion();
                simCardEntry.SIM_SERIAL_NUMBER = telephonyManager.getSimSerialNumber();

                e.onNext(simCardEntry);
                e.onComplete();
            }
        });
    }
}
