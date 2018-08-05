/*
 * Copyright (c) 2018 Jonathan Monga <jmonga98@gmail.com>
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

package com.jonathan.simcardinfo.models.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class PhoneEntry implements Parcelable {
    public static final Creator<PhoneEntry> CREATOR = new Creator<PhoneEntry>() {
        public PhoneEntry createFromParcel(Parcel source) {
            return new PhoneEntry(source);
        }

        public PhoneEntry[] newArray(int size) {
            return new PhoneEntry[size];
        }
    };

    public String BOARD;
    public String BOOTLOADER;
    public String BRAND;
    public String CPU_ABI;
    public String CPU_ABI2;
    public String DEVICE;
    public String DISPLAY;
    public String FINGERPRINT;
    public String HARDWARE;
    public String HOST;
    public String ID;
    public String MANUFACTURER;
    public String MODEL;
    public String PRODUCT;
    public String SERIAL;
    public String TAGS;
    public String TYPE;
    public String USER;
    public String CODENAME;
    public String INCREMENTAL;
    public String SDK_INT;
    public String RADIO_VERSION;
    public String RELEASE;

    public PhoneEntry() {}

    private PhoneEntry(Parcel in) {
        this.BOARD = in.readString();
        this.BOOTLOADER = in.readString();
        this.BRAND = in.readString();
        this.CPU_ABI = in.readString();
        this.CPU_ABI2 = in.readString();
        this.DEVICE = in.readString();
        this.DISPLAY = in.readString();
        this.FINGERPRINT = in.readString();
        this.HARDWARE = in.readString();
        this.HOST = in.readString();
        this.ID = in.readString();
        this.INCREMENTAL = in.readString();
        this.MANUFACTURER = in.readString();
        this.MODEL = in.readString();
        this.PRODUCT = in.readString();
        this.SDK_INT = in.readString();
        this.SERIAL = in.readString();
        this.TAGS = in.readString();
        this.TYPE = in.readString();
        this.USER = in.readString();
        this.CODENAME = in.readString();
        this.RADIO_VERSION = in.readString();
        this.RELEASE = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.BOARD);
        dest.writeString(this.BOOTLOADER);
        dest.writeString(this.BRAND);
        dest.writeString(this.CODENAME);
        dest.writeString(this.CPU_ABI);
        dest.writeString(this.CPU_ABI2);
        dest.writeString(this.DEVICE);
        dest.writeString(this.DISPLAY);
        dest.writeString(this.FINGERPRINT);
        dest.writeString(this.HARDWARE);
        dest.writeString(this.HOST);
        dest.writeString(this.ID);
        dest.writeString(this.INCREMENTAL);
        dest.writeString(this.MANUFACTURER);
        dest.writeString(this.MODEL);
        dest.writeString(this.PRODUCT);
        dest.writeString(this.SDK_INT);
        dest.writeString(this.SERIAL);
        dest.writeString(this.TAGS);
        dest.writeString(this.TYPE);
        dest.writeString(this.USER);
        dest.writeString(this.RADIO_VERSION);
        dest.writeString(this.RELEASE);
    }
}
