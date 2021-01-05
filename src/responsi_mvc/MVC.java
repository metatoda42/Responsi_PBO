package responsi_mvc;



public class MVC {
	ViewResponsi vp = new ViewResponsi();
    ModelResponsi mp = new ModelResponsi();
    ControllerResponsi cp = new ControllerResponsi(vp, mp);
}
