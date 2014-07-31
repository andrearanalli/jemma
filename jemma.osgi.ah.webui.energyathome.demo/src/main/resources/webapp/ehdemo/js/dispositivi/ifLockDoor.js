var ifLockDoor =  { 
        timeout_timer:null,
        clusters:{},
        UPDATE_FREQ: 30000,
        stato:1 //1=acceso
}

ifLockDoor.init=function(clusters){  

	ifLockDoor.timeout_timer=null;
	ifLockDoor.stato=-1;
        
        
	ifLockDoor.update(true);
    
};

ifLockDoor.updateIcon=function(stato){
        
        if (stato!=1 && stato!=0) {
                stato=null;
        }
        var i= $("#Interfaccia").data("current_index");
        var icona_src= "Resources/Images/Devices2/"+Elettrodomestici.getIcon(Elettrodomestici.listaElettrodomestici[i],stato);
        
        $("#Interfaccia .icona .icona-dispositivo").attr("src",icona_src);
        
        var class_stato="NP";
        
        if (stato==1) {
                class_stato="ON";
        }
        else if (stato==0){
                class_stato="OFF";
        }
        $("#Interfaccia .icona").removeClass("ON");
        $("#Interfaccia .icona").removeClass("OFF");
        $("#Interfaccia .icona").addClass(class_stato);
        
}

ifLockDoor.update= function(now){
        
        var t= new Date().getTime();
        
        var i= $("#Interfaccia").data("current_index");

        var consumo=Elettrodomestici.listaElettrodomestici[i].consumo;
        if (consumo!="n.a.") {
                consumo=Math.round(Elettrodomestici.listaElettrodomestici[i].consumo)+"W";
        }
        $("#Interfaccia .StatoElettrodomestico .consumo").text(consumo);
        $("#Interfaccia .StatoElettrodomestico .posizione_value").text(Elettrodomestici.locazioni[Elettrodomestici.listaElettrodomestici[i].location]);
        
        
        
        //Non aggiorno oltre l'interfaccia se passa troppo poco tempo dall'ultimo comando
        if (!now && ifLockDoor.timeout_timer!=null) {
                if (t - ifLockDoor.timeout_timer < ifLockDoor.UPDATE_FREQ) {
                        return;
                }
        }
        
        ifLockDoor.timeout_timer=t;
        
        var class_stato="NP"
        var t_value="";
        var h_value="";
        
        if (Elettrodomestici.listaElettrodomestici[i].connessione==2) {
                
        	ifLockDoor.stato=1;
                //_value=Elettrodomestici.listaElettrodomestici[i].consumo_value;
                t_value=Elettrodomestici.listaElettrodomestici[i].temperature+" °";
                h_value=Elettrodomestici.listaElettrodomestici[i].humidity+" %"
                
        }else{
                t_value="n.a.";
                h_value="n.a.";
                ifLockDoor.stato=-1;
        }
        
        $("#Interfaccia #Temperatura #temperatura_value").text(t_value);
        $("#Interfaccia #Humidity #humidity_value").text(h_value);
        
        ifLockDoor.updateIcon(ifThermostat.stato);
}