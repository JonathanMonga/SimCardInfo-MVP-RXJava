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

public class SimCardEntry implements Parcelable {
    public static final Creator<SimCardEntry> CREATOR = new Creator<SimCardEntry>() {
        public SimCardEntry createFromParcel(Parcel source) {
            return new SimCardEntry(source);
        }

        public SimCardEntry[] newArray(int size) {
            return new SimCardEntry[size];
        }
    };

    public String SIM_CONTRY_ISO;
    public String NETWORK_OPERATOR_NAME;
    public String SIM_OPERATOR_NAME;
    public boolean NETWORK_ROAMING;
    public String DEVICE_ID;
    public String VOICE_MAIL_ALPHA_TAG;
    public String DEVICE_SOFTWARE_VERSION;
    public String SIM_SERIAL_NUMBER;

    public SimCardEntry() {}

    private SimCardEntry(Parcel in) {
        this.SIM_CONTRY_ISO = in.readString();
        this.SIM_OPERATOR_NAME = in.readString();
        this.SIM_SERIAL_NUMBER = in.readString();
        this.NETWORK_OPERATOR_NAME = in.readString();
        this.NETWORK_ROAMING = in.readByte() != 0;;
        this.DEVICE_ID = in.readString();
        this.DEVICE_SOFTWARE_VERSION = in.readString();
        this.VOICE_MAIL_ALPHA_TAG = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.SIM_CONTRY_ISO);
        dest.writeString(this.SIM_OPERATOR_NAME);
        dest.writeString(this.SIM_SERIAL_NUMBER);
        dest.writeString(this.NETWORK_OPERATOR_NAME);
        dest.writeByte(NETWORK_ROAMING ? (byte) 1 : (byte) 0);
        dest.writeString(this.DEVICE_ID);
        dest.writeString(this.DEVICE_SOFTWARE_VERSION);
        dest.writeString(this.VOICE_MAIL_ALPHA_TAG);
    }
}
