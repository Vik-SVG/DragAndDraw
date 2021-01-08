package com.ltutorialapp.draganddraw;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

public class Box implements Parcelable {
    private PointF mOrigin;
    private PointF mCurrent;
    private PointF mPointerOrigin;
    private float  angle;

    public Box(PointF origin){
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getPointerOrigin() {
        return mPointerOrigin;
    }

    public void setPointerOrigin(PointF pointerOrigin) {
        mPointerOrigin = pointerOrigin;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }


    public PointF getCurrent(){
        return mCurrent;
    }

    public void setCurrent(PointF current){
        mCurrent=current;
    }

    public PointF getOrigin() {
        return mOrigin;
    }



   /* protected Box(Parcel in) {
        mOrigin = (PointF) in.readValue(PointF.class.getClassLoader());
        mCurrent = (PointF) in.readValue(PointF.class.getClassLoader());
        mPointerOrigin = (PointF) in.readValue(PointF.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mOrigin);
        dest.writeValue(mCurrent);
        dest.writeValue(mPointerOrigin);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Box> CREATOR = new Parcelable.Creator<Box>() {
        @Override
        public Box createFromParcel(Parcel in) {
            return new Box(in);
        }

        @Override
        public Box[] newArray(int size) {
            return new Box[size];
        }
    };*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mOrigin, flags);
        dest.writeParcelable(this.mCurrent, flags);
        dest.writeParcelable(this.mPointerOrigin, flags);
        dest.writeFloat(this.angle);
    }

    protected Box(Parcel in) {
        this.mOrigin = in.readParcelable(PointF.class.getClassLoader());
        this.mCurrent = in.readParcelable(PointF.class.getClassLoader());
        this.mPointerOrigin = in.readParcelable(PointF.class.getClassLoader());
        this.angle = in.readFloat();
    }

    public static final Parcelable.Creator<Box> CREATOR = new Parcelable.Creator<Box>() {
        @Override
        public Box createFromParcel(Parcel source) {
            return new Box(source);
        }

        @Override
        public Box[] newArray(int size) {
            return new Box[size];
        }
    };
}
