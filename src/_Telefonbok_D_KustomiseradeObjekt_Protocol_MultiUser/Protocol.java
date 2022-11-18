package _Telefonbok_D_KustomiseradeObjekt_Protocol_MultiUser;

public class Protocol {


    final protected static int INITIAL = 0;
    final protected static int INTHELOOP = 1;

    protected int state = INITIAL;

    TCP_Database database = new TCP_Database();
    TCP_Object dataBaseResponse;

    public Object getOutput(String input){

        Object output = null;

        if (state == INITIAL) {
            output = new Initiator();
            state = INTHELOOP;

        } else if (state == INTHELOOP) {
            dataBaseResponse = database.search(input.trim());

            if (dataBaseResponse == null) {
                output = new Response(false);

            } else {
                output = new Response(true, dataBaseResponse);
            }
        }
        return output;
    }
}
