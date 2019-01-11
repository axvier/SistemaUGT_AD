package ugt.solicitudes;

/**
 *
 * @author Xavy PC
 */
public class EventoAgenda {

    private String id;
    private String title;
    private String start;
    private String end;
    private String url;
    private String rendering;
    private boolean overlap;
    private boolean resourceEditable;

    public boolean isResourceEditable() {
        return resourceEditable;
    }

    public void setResourceEditable(boolean resourceEditable) {
        this.resourceEditable = resourceEditable;
    }
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRendering() {
        return rendering;
    }

    public void setRendering(String rendering) {
        this.rendering = rendering;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
