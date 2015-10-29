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

public class ResponsePeerSearch extends Response {

    public static final int HEADER = 0xea;
    public static ResponsePeerSearch fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponsePeerSearch(), data);
    }

    private List<ApiPeerSearchResult> searchResults;
    private List<ApiUser> users;
    private List<ApiGroup> groups;

    public ResponsePeerSearch(@NotNull List<ApiPeerSearchResult> searchResults, @NotNull List<ApiUser> users, @NotNull List<ApiGroup> groups) {
        this.searchResults = searchResults;
        this.users = users;
        this.groups = groups;
    }

    public ResponsePeerSearch() {

    }

    @NotNull
    public List<ApiPeerSearchResult> getSearchResults() {
        return this.searchResults;
    }

    @NotNull
    public List<ApiUser> getUsers() {
        return this.users;
    }

    @NotNull
    public List<ApiGroup> getGroups() {
        return this.groups;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<ApiPeerSearchResult> _searchResults = new ArrayList<ApiPeerSearchResult>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _searchResults.add(new ApiPeerSearchResult());
        }
        this.searchResults = values.getRepeatedObj(1, _searchResults);
        List<ApiUser> _users = new ArrayList<ApiUser>();
        for (int i = 0; i < values.getRepeatedCount(2); i ++) {
            _users.add(new ApiUser());
        }
        this.users = values.getRepeatedObj(2, _users);
        List<ApiGroup> _groups = new ArrayList<ApiGroup>();
        for (int i = 0; i < values.getRepeatedCount(3); i ++) {
            _groups.add(new ApiGroup());
        }
        this.groups = values.getRepeatedObj(3, _groups);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.searchResults);
        writer.writeRepeatedObj(2, this.users);
        writer.writeRepeatedObj(3, this.groups);
    }

    @Override
    public String toString() {
        String res = "tuple PeerSearch{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}