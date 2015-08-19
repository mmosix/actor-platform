package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class RequestNotifyBannerView extends Request<ResponseVoid> {

    public static final int HEADER = 0xa2;
    public static RequestNotifyBannerView fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestNotifyBannerView(), data);
    }

    private int bannerId;
    private int viewDuration;

    public RequestNotifyBannerView(int bannerId, int viewDuration) {
        this.bannerId = bannerId;
        this.viewDuration = viewDuration;
    }

    public RequestNotifyBannerView() {

    }

    public int getBannerId() {
        return this.bannerId;
    }

    public int getViewDuration() {
        return this.viewDuration;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.bannerId = values.getInt(1);
        this.viewDuration = values.getInt(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.bannerId);
        writer.writeInt(2, this.viewDuration);
    }

    @Override
    public String toString() {
        String res = "rpc NotifyBannerView{";
        res += "bannerId=" + this.bannerId;
        res += ", viewDuration=" + this.viewDuration;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}