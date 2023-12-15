# Simple_Login_App


L'applicazione si occupa di gestire un processo di autenticazione tramite inserimento di username e password.
Qualora la combinazione di username e password fosse corretta, allora il client sarebbe rediretto su pagina 
welcome che da benvenuto all'utente loggato ("Benvenuto Pippo").  e sotto una tabella contenente tutti gli utenti censiti su DB.
Qualora invece non ci fosse riscontro positivo, il client si troverebbe nuovamente su pagina di autenticazione
che ravvisa un messaggio di errrore in rosso ("CREDENZIALI ERRATE")

COMPOSIZIONE
2 pagine .jsp (login.jsp, welcome.jsp)
1 servlet (controller)
1 dao (Data Access Object, è la classe dove si recupera connessione e si eseguono le query)

TECNOLOGIE
Tomcat 9, Servlet e JSP, Connettore MySQL e Datasource (su Tomcat)

DB
utente(id, username, password, email)
