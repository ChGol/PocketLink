package com.training.christian.pocketlink;

import android.content.Context;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class SqlLiteLinkDatabase implements iLinkDataBase {

    private Dao<Link, Integer> mDao;

    public SqlLiteLinkDatabase(Context context) {
        DataBaseOpenHelper openHelper = new DataBaseOpenHelper(context);
        ConnectionSource connectionSource = new AndroidConnectionSource(openHelper);
        try {
            mDao = DaoManager.createDao(connectionSource, Link.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Link> getLinks() {
        try {
            return mDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void create(Link link) {
        try {
            mDao.create(link);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
