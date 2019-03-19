package kr.co.woobi.imyeon.callbackinfragmentreview;

public class EventItem {
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public EventItem(int position) {
        this.color = position;
    }
}
