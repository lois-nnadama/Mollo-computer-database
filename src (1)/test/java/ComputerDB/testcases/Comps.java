package ComputerDB.testcases;


import ComputerDB.base.DriverInstance;
import ComputerDB.pages.Computer;
import org.testng.annotations.Test;

import java.io.IOException;

public class Comps extends DriverInstance {

    @Test
    public void Comps() throws IOException, InterruptedException {
        Computer compobj = new Computer();
        compobj.GetUrl();
        compobj.CreateComp();
        compobj.UpdateComp();
        compobj.ViewComp();
        compobj.DeleteComp();

    }
}

