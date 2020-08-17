package com.mobilesafeapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mobilesafeapp.db.dao.BlackNumberDao;
import com.mobilesafeapp.db.domain.BlackNumberInfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Random;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    public void useAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.mobilesafeapp", appContext.getPackageName());
    }

    public void insert() {
        BlackNumberDao dao = BlackNumberDao.getInstance(appContext);
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                dao.insert("1860000000" + i, 1 + new Random().nextInt(3) + "");
            } else {
                dao.insert("186000000" + i, 1 + new Random().nextInt(3) + "");
            }
        }
    }

    public void delete() {
        BlackNumberDao dao = BlackNumberDao.getInstance(appContext);
        dao.delete("110");
    }

    public void update() {
        BlackNumberDao dao = BlackNumberDao.getInstance(appContext);
        dao.update("110", "2");
    }

    public void findAll() {
        BlackNumberDao dao = BlackNumberDao.getInstance(appContext);
        List<BlackNumberInfo> blackNumberInfoList = dao.findAll();
    }
}