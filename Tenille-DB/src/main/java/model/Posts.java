/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author t2alaska
 */
public class Posts {
        private String user;
        private String date;
        private String message;
        
    public Posts(){
            setUser("");
            setDate("");
            setMessage("");
        }

     public Posts(String user, String date, String message) {
        this.setUser(user);
        this.setDate(date);
        this.setMessage(message);
      }


      public void setUser(String user) {
        this.user = user;
      }

      public String getUser() {
        return user;
      }

       public void setDate(String date) {
        this.date = date;
      }
      public String getDate() {
        return date;
      }

      public void setMessage(String message) {
        this.message = message;
      }

      public String getMessage() {
        return message;
      }

          @Override
        public String toString() {
          return "<tr><td>" + user + "</td><td>" + date + "</td><td>" + message + "</td></tr>";
        }

      public String toFileString() {
                return user + "," + date + "," + message;
         }

         public void loadFromFileString(String str) {
                // TODO: Validation should be done here
                String[] posts = str.split(",");


                user = posts[0];
                message = posts[1];
                date = posts[2];
         }
    
}
