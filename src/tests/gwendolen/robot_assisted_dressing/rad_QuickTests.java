// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis and Mengwei Xu
//
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
//
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.robot_assisted_dressing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import junit.framework.Assert;

import org.junit.Test;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

public class rad_QuickTests {
    static final String[] JPF_ARGS = { "suppress_version = true" };



    @Test //----------------------------------------------------------------------
    public void prism_output () {
        String jpf_config = "src/examples/gwendolen/robot_assisted_dressing/assisted_dressing_monitor.jpf";

        Config conf = JPF.createConfig(JPF_ARGS);
        FileInputStream is = null;
        try {
            File f = new File(jpf_config);
            if (f.isFile()) {
                is = new FileInputStream(f);
                conf.load(is);
            }
            JPF jpf = new JPF(conf);
            jpf.run();

            String example_path = conf.getProperty("mcapl") + "/src/examples/gwendolen/robot_assisted_dressing/";
            String example_filename = example_path + "assisted_dressing_monitor_example.pm";
            String test_filename = example_path + "assisted_dressing_monitor_all_beliefs_including_success.pm";

            File example_file = new File(example_filename);
            File test_file = new File(test_filename);

            Path epath = example_file.toPath();
            Path tpath = test_file.toPath();

            Assert.assertTrue(sameContent(epath, tpath));
        } catch (Exception e) {
            Assert.assertFalse(true);
        }
    }

    boolean sameContent(Path file1, Path file2) throws IOException {

        try (InputStream is1 = Files.newInputStream(file1);
             InputStream is2 = Files.newInputStream(file2)) {
            // Compare byte-by-byte.
            // Note that this can be sped up drastically by reading large chunks
            // (e.g. 16 KBs) but care must be taken as InputStream.read(byte[])
            // does not neccessarily read a whole array!
            int data;
            while ((data = myread(is1)) != -1)
                if (data != myread(is2))
                    return false;
        }

        return true;
    }

    private int myread(InputStream is) throws IOException {
        int c;
        do {
            c = is.read();
        } while (c == '\n' || c == '\r');
        return c;
    }


}
