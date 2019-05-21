import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Issue {
    private final String summary;
    private final String description;

    public Issue(final @NotNull String summary, final @Nullable String description) {
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
