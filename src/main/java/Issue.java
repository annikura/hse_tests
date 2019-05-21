import org.jetbrains.annotations.NotNull;

public class Issue {
    private final String summary;
    private final String description;

    public Issue(final @NotNull String summary, final @NotNull String description) {
        this.summary = summary;
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }
}
