package com.examples;

import junit.framework.Assert;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.Test;

import javax.swing.*;

/**
 * Created by ka40215 on 7/20/15.
 */
public class CalcServiceTest {
    @Test
    public void testCalcService(){
        CalcService calcService = new CalcService();
        ICalc calcMock = EasyMock.createMock(ICalc.class);
        calcService.setCalc(calcMock);

        EasyMock.expect(calcMock.add(10, 10)).andReturn(20);
        EasyMock.replay(calcMock);
        EasyMock.verify();
        Assert.assertEquals(20, calcService.addN(10, 10));
    }
}
