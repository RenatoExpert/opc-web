package com.shogunautomacao.app;

import java.util.concurrent.Executors;
import org.jinterop.dcom.common.JIException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.AccessBase;
import org.openscada.opc.lib.da.DataCallback;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.openscada.opc.lib.da.SyncAccess;

public class App {
    public static void main(String[] args) throws Exception {
        // create connection information
        final ConnectionInformation ci = new ConnectionInformation();
        ci.setHost("opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/");
        ci.setDomain("");
        ci.setUser("your user");
        ci.setPassword("your password");
        ci.setProgId("SWToolbox.TOPServer.V5");
        // ci.setClsid("680DFBF7-C92D-484D-84BE-06DC3DECCD68"); // if ProgId is not working, try it using the Clsid instead
        final String itemId = "_System._Time_Second";
        // create a new server
        final Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());

        try {
            // connect to server
            server.connect();
            // add sync access, poll every 500 ms
            final AccessBase access = new SyncAccess(server, 500);
            access.addItem(itemId, new DataCallback() {
                @Override
                public void changed(Item item, ItemState state) {
                    System.out.println(state);
                }
            });
            // start reading
            access.bind();
            // wait a little bit
            Thread.sleep(10 * 1000);
            // stop reading
            access.unbind();
        } catch (final JIException e) {
            System.out.println(String.format("%08X: %s", e.getErrorCode(), server.getErrorMessage(e.getErrorCode())));
        }
    }
}
