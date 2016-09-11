package edu.zyr.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class CreateConnertionTest {
    @Test
    public void connection(){
        Assert.assertNotNull(CreateConnertion.getConnertion());
    }
}
