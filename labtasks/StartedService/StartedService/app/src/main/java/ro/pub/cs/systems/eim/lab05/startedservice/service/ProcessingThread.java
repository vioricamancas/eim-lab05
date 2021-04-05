package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class ProcessingThread extends Thread {

    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true){
            sendMessage(Constants.MESSAGE_STRING);
            Log.d("cttag", "sent message for sth");
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        switch(messageType) {
            case Constants.MESSAGE_STRING:
                intent.setAction(Constants.ACTION_STRING);
                intent.putExtra(Constants.DATA, Constants.STRING_DATA);
                break;
            // ...
        }
        context.sendBroadcast(intent);
    }
}
