package com.alamkanak.weekview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.alamkanak.weekview.WeekViewUtil.isSameDay;

/**
 * Created by Raquib-ul-Alam Kanak on 7/21/2014.
 * Website: http://april-shower.com
 */
public class WeekViewEvent {
    public static String OFFICE_HOUR_TITLE = "Office hours";
    public static String TIME_OFF_TITLE = "Out of office";
    public static String OFFICE_HOUR = "office_hour";
    public static String TIME_OFF = "time_off";
    public static String APPOINTMENT = "appointment";
    private long mId;
    private Calendar mStartTime;
    private Calendar mEndTime;
    private CharSequence mName;
    private CharSequence mDescription = "";
    private CharSequence mLocation;
    private int mBackgroundColor;
    private Integer mTextColor;
    private boolean mAllDay;
    private Long mDuration;
    private Long mDurationInMinutes;
    private String externalResourceId;
    private String mEventType;

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param startYear Year when the event starts.
     * @param startMonth Month when the event starts.
     * @param startDay Day when the event starts.
     * @param startHour Hour (in 24-hour format) when the event starts.
     * @param startMinute Minute when the event starts.
     * @param endYear Year when the event ends.
     * @param endMonth Month when the event ends.
     * @param endDay Day when the event ends.
     * @param endHour Hour (in 24-hour format) when the event ends.
     * @param endMinute Minute when the event ends.
     */
    public WeekViewEvent(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        this.mId = id;

        this.mStartTime = Calendar.getInstance();
        this.mStartTime.set(Calendar.YEAR, startYear);
        this.mStartTime.set(Calendar.MONTH, startMonth-1);
        this.mStartTime.set(Calendar.DAY_OF_MONTH, startDay);
        this.mStartTime.set(Calendar.HOUR_OF_DAY, startHour);
        this.mStartTime.set(Calendar.MINUTE, startMinute);

        this.mEndTime = Calendar.getInstance();
        this.mEndTime.set(Calendar.YEAR, endYear);
        this.mEndTime.set(Calendar.MONTH, endMonth-1);
        this.mEndTime.set(Calendar.DAY_OF_MONTH, endDay);
        this.mEndTime.set(Calendar.HOUR_OF_DAY, endHour);
        this.mEndTime.set(Calendar.MINUTE, endMinute);

        this.mName = name;
    }

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     * @param allDay Is the event an all day event.
     * @param eventType Is the type of event.
     */
    public WeekViewEvent(long id, CharSequence name, CharSequence location, Calendar startTime, Calendar endTime, boolean allDay, String eventType) {
        this.mId = id;
        this.mName = name;
        this.mLocation = location;
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        this.mAllDay = allDay;
        this.mEventType = eventType;
    }

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     * @param allDay Is the event an all day event.
     */
    public WeekViewEvent(long id, CharSequence name, CharSequence location, Calendar startTime, Calendar endTime, boolean allDay) {
        this(id, name, location, startTime, endTime, allDay, null);
    }

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     */
    public WeekViewEvent(long id, CharSequence name, CharSequence location, Calendar startTime, Calendar endTime) {
        this(id, name, location, startTime, endTime, false);
    }

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     */
    public WeekViewEvent(long id, CharSequence name, Calendar startTime, Calendar endTime) {
        this(id, name, null, startTime, endTime);
    }

    public Calendar getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Calendar startTime) {
        this.mStartTime = startTime;
    }

    public Calendar getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Calendar endTime) {
        this.mEndTime = endTime;
    }

    public CharSequence getName() {
        return mName;
    }

    public String getEventType() {
        return mEventType;
    }

    public void setName(CharSequence name) {
        this.mName = name;
    }

    public void setDescription(CharSequence description) {
        this.mDescription = description;
    }

    public CharSequence getDescription() {
        return mDescription;
    }

    public CharSequence getLocation() {
        return mLocation;
    }

    public void setLocation(CharSequence location) {
        this.mLocation = location;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public void setBackgroundColor(int color) {
        this.mBackgroundColor = color;
    }

    public Integer getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public boolean isAllDay() {
        return mAllDay;
    }

    public void setAllDay(boolean allDay) {
        this.mAllDay = allDay;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public void setExternalResourceId(String externalResourceId) {
        this.externalResourceId = externalResourceId;
    }

    public String getExternalResourceId() {
        return externalResourceId;
    }

    public long getDuration(){
        if (mDuration == null){
            mDuration = Math.abs(mEndTime.getTimeInMillis() - mStartTime.getTimeInMillis());
        }
        return mDuration;
    }

    public long getDurationInMinutes(){
        if (mDurationInMinutes == null) {
            mDurationInMinutes = TimeUnit.MILLISECONDS.toMinutes(getDuration());;
        }
        return mDurationInMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekViewEvent that = (WeekViewEvent) o;

        return mId == that.mId;

    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public List<WeekViewEvent> splitWeekViewEvents(){
        //This function splits the WeekViewEvent in WeekViewEvents by day
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
        // The first millisecond of the next day is still the same day. (no need to split events for this).
        Calendar endTime = (Calendar) this.getEndTime().clone();
        endTime.add(Calendar.MILLISECOND, -1);
        if (!isSameDay(this.getStartTime(), endTime)) {
            endTime = (Calendar) this.getStartTime().clone();
            endTime.set(Calendar.HOUR_OF_DAY, 23);
            endTime.set(Calendar.MINUTE, 59);
            WeekViewEvent event1 = new WeekViewEvent(this.getId(), this.getName(), this.getLocation(), this.getStartTime(), endTime, this.isAllDay(), this.mEventType);
            event1.setBackgroundColor(this.getBackgroundColor());
            events.add(event1);

            // Add other days.
            Calendar otherDay = (Calendar) this.getStartTime().clone();
            otherDay.add(Calendar.DATE, 1);
            while (!isSameDay(otherDay, this.getEndTime())) {
                Calendar overDay = (Calendar) otherDay.clone();
                overDay.set(Calendar.HOUR_OF_DAY, 0);
                overDay.set(Calendar.MINUTE, 0);
                Calendar endOfOverDay = (Calendar) overDay.clone();
                endOfOverDay.set(Calendar.HOUR_OF_DAY, 23);
                endOfOverDay.set(Calendar.MINUTE, 59);
                WeekViewEvent eventMore = new WeekViewEvent(this.getId(), this.getName(), null, overDay, endOfOverDay, this.isAllDay());
                eventMore.setBackgroundColor(this.getBackgroundColor());
                events.add(eventMore);

                // Add next day.
                otherDay.add(Calendar.DATE, 1);
            }

            // Add last day.
            Calendar startTime = (Calendar) this.getEndTime().clone();
            startTime.set(Calendar.HOUR_OF_DAY, 0);
            startTime.set(Calendar.MINUTE, 0);
            WeekViewEvent event2 = new WeekViewEvent(this.getId(), this.getName(), this.getLocation(), startTime, this.getEndTime(), this.isAllDay(), this.mEventType);
            event2.setBackgroundColor(this.getBackgroundColor());
            events.add(event2);
        }
        else{
            events.add(this);
        }

        return events;
    }
}
