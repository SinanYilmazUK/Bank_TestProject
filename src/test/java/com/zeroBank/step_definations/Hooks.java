package com.zeroBank.step_definations;

import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){

        Driver.get().get(ConfigurationReader.get("url"));


    }

    @After
    public void teardown(){

        Driver.closeDriver();
    }
}
