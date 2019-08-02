/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.freemarks;

import net.michaelhofmann.usecasefull.usecase.UseCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class StandardPlusGetterTest {
    
    private UseCase useCase;
    private StandardPlusGetter freemarks;
    
    public StandardPlusGetterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        freemarks = new StandardPlusGetter();
        useCase = new UseCase();
        freemarks.init(useCase);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProgressBarWithLabel method, of class StandardPlusGetter.
     */
    @Test
    public void testGetProgressBarWithLabel() {
        printProgressBarWithLabel(-23);
        printProgressBarWithLabel(0);
        printProgressBarWithLabel(1);
        printProgressBarWithLabel(9);
        printProgressBarWithLabel(11);
        printProgressBarWithLabel(23);
        printProgressBarWithLabel(49);
        printProgressBarWithLabel(50);
        printProgressBarWithLabel(51);
        printProgressBarWithLabel(76);
        printProgressBarWithLabel(99);
        printProgressBarWithLabel(100);
        printProgressBarWithLabel(130975309);
    }
    
    private String printProgressBarWithLabel(int percent) {
        useCase.getState().setPercent(percent);
        String bar = freemarks.getProgressBarWithLabel();
        System.out.println(bar);
        return bar;
    }
    
}
