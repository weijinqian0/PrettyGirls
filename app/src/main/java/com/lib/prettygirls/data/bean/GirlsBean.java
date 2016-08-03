package com.lib.prettygirls.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by weijinqian on 16/8/2.
 */
public class GirlsBean {
    private boolean error;
    private List<ResultEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultEntity> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<ResultEntity> getResults() {
        return results;
    }

    public static class ResultEntity implements Parcelable{
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        protected ResultEntity(Parcel in) {
            _id = in.readString();
            createdAt = in.readString();
            desc = in.readString();
            publishedAt = in.readString();
            source = in.readString();
            type = in.readString();
            url = in.readString();
            used = in.readByte() != 0;
            who = in.readString();
        }

        public static final Creator<ResultEntity> CREATOR = new Creator<ResultEntity>() {
            @Override
            public ResultEntity createFromParcel(Parcel in) {
                return new ResultEntity(in);
            }

            @Override
            public ResultEntity[] newArray(int size) {
                return new ResultEntity[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(_id);
            dest.writeString(createdAt);
            dest.writeString(desc);
            dest.writeString(publishedAt);
            dest.writeString(source);
            dest.writeString(type);
            dest.writeString(url);
            dest.writeByte((byte) (used ? 1 : 0));
            dest.writeString(who);
        }
    }
}
