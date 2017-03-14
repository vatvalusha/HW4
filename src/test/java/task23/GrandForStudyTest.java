package task23;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class GrandForStudyTest {
    @Test
    public void nextSateGrandDeferred() throws Exception {
        State withdrawn = new GrandDeferred();
        GrandForStudy study = new GrandForStudy();
        study.setState(withdrawn);
        study.nextSate();
        assertTrue(study.getState() instanceof GrandView);
    }

    @Test
    public void nextStateGrandConfirmed(){
        State withdrawn = new GrandConfirmed();
        GrandForStudy study = new GrandForStudy();
        study.setState(withdrawn);
        study.nextSate();
        assertTrue(study.getState() instanceof GrandCreate);

    }
}