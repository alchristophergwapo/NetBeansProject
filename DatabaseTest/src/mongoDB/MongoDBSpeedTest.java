/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoDB;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.model.Aggregates.*;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Christopher Alonzo
 */
public class MongoDBSpeedTest {

    public void insertWithConnection1K() throws UnknownHostException {

        long timeStart = new Date().getTime() / 1000;
        for (int i = 1; i < 1001; i++) {

            try {
                Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
                mongoLogger.setLevel(Level.SEVERE);
                MongoClient mongoClient = new MongoClient("localhost", 27017);
                DB db = mongoClient.getDB("alonzo");
                DBCollection collection = db.getCollection("dataCollection");
                BasicDBObject object = new BasicDBObject("Column_1", i)
                        .append("Column_2", i + 1)
                        .append("Column_3", i + 2)
                        .append("Column_4", i + 3)
                        .append("Column_5", i + 4);
                collection.insert(object);
                System.out.println("Inserted successfully " + i);

            } catch (SecurityException e) {
                System.out.println(e);
            }
        }
        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public void insertWithoutConnection1K() throws UnknownHostException {
        long timeStart = new Date().getTime() / 1000;

        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("alonzo");
            DBCollection collection = db.getCollection("dataCollection");
            for (int i = 1; i < 1001; i++) {
                BasicDBObject object = new BasicDBObject("Column_1", i)
                        .append("Column_2", i + 1)
                        .append("Column_3", i + 2)
                        .append("Column_4", i + 3)
                        .append("Column_5", i + 4);
                collection.insert(object);
                System.out.println("Inserted successfully " + i);
            }
        } catch (SecurityException e) {
            System.out.println(e);
        }

        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public void deleteWithConnection1K() throws UnknownHostException {

        long timeStart = new Date().getTime() / 1000;

        for (int i = 1; i < 1001; i++) {

            try {
                Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
                mongoLogger.setLevel(Level.SEVERE);
                MongoClient mongoClient = new MongoClient("localhost", 27017);
                DB db = mongoClient.getDB("alonzo");
                DBCollection collection = db.getCollection("dataCollection");

//                BasicDBObject remove1000 = new BasicDBObject("Column_1", i);
                collection.remove(new BasicDBObject("Column_1", i));
                System.out.println("Successfully deleted! " + i);

            } catch (SecurityException e) {
                System.out.println(e);
            }
        }
        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public void deleteWithoutConnection1K() throws UnknownHostException {
        long timeStart = new Date().getTime() / 1000;

        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("alonzo");
            DBCollection collection = db.getCollection("dataCollection");
            for (int i = 1; i < 1001; i++) {
//                BasicDBObject remove1000 = new BasicDBObject("Column_1", i);
                collection.remove(new BasicDBObject("Column_1", i));
                System.out.println("Successfully deleted! " + i);
            }
        } catch (SecurityException e) {
            System.out.println(e);
        }
        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public void GetAverageUsingJavaLoop() {

        long timeStart = new Date().getTime() / 1000;
        int avgColumn_1 = 0;
        int avgColumn_2 = 0;
        int avgColumn_3 = 0;
        int avgColumn_4 = 0;
        int avgColumn_5 = 0;
        for (int i = 1; i < 1001; i++) {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("alonzo");
            DBCollection collection = db.getCollection("dataCollection");
            BasicDBObject query = new BasicDBObject();
            query.put("Column_1", i);
            DBCursor c = collection.find(query);

            while (c.hasNext()) {
                avgColumn_1 += Integer.parseInt(c.next().get("Column_1").toString());
            }

            BasicDBObject query2 = new BasicDBObject();
            query2.put("Column_2", i + 1);
            DBCursor c2 = collection.find(query2);

            while (c2.hasNext()) {
                avgColumn_2 += Integer.parseInt(c2.next().get("Column_2").toString());
            }

            BasicDBObject query3 = new BasicDBObject();
            query3.put("Column_3", i + 2);
            DBCursor c3 = collection.find(query3);

            while (c3.hasNext()) {
                avgColumn_3 += Integer.parseInt(c3.next().get("Column_3").toString());
            }

            BasicDBObject query4 = new BasicDBObject();
            query4.put("Column_4", i + 3);
            DBCursor c4 = collection.find(query4);

            while (c4.hasNext()) {
                avgColumn_4 += Integer.parseInt(c4.next().get("Column_4").toString());
            }

            BasicDBObject query5 = new BasicDBObject();
            query5.put("Column_5", i + 4);
            DBCursor c5 = collection.find(query5);

            while (c5.hasNext()) {
                avgColumn_5 += Integer.parseInt(c5.next().get("Column_5").toString());
            }

        }

        System.out.println(avgColumn_1 / 1000);
        System.out.println(avgColumn_2 / 1000);
        System.out.println(avgColumn_3 / 1000);
        System.out.println(avgColumn_4 / 1000);
        System.out.println(avgColumn_5 / 1000);

        long timeFinish = new Date().getTime() / 1000;

        System.out.println("Time interval in milliseconds: " + (timeFinish - timeStart));
    }

    public void getAverageUsingMongoAverage() {
        long timeStart = new Date().getTime() / 1000;
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("alonzo");
        DBCollection collection = db.getCollection("dataCollection");
        for (int i = 1; i < 1001; i++) {

            
AggregateIterable output = collection.aggregate(Arrays.asList(
                unwind("$views"),
                match(new Document("views.isActive",true)),
                sort(new Document("views.date",1)),
                limit(200)
//                project(new Document("_id",0)
//                        .append("url","$views.url")
//                        .append("date","$views.date"))
));

        }
        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public static void main(String[] args) {
        MongoDBSpeedTest db = new MongoDBSpeedTest();
//        try {
//            db.insertWithConnection1K();
//            db.deleteWithConnection1K();
//            db.insertWithoutConnection1K();
//            db.deleteWithoutConnection1K();

//        } catch (UnknownHostException ex) {
//            Logger.getLogger(MongoDBSpeedTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        db.getAverageUsingMongoAverage();
//        db.GetAverageUsingJavaLoop();
    }
}
