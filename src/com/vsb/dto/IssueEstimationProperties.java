package dto;

import org.kohsuke.github.GHLabel;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class IssueEstimationProperties {
    private Collection<GHLabel> labels;
    private Date closedAt;
    private List<GHUser> participants;
    
    public IssueEstimationProperties(){
    }

    public IssueEstimationProperties(Collection<GHLabel> labels, Date closedAt, List<GHUser> participants) {
        this.labels = labels;
        this.closedAt = closedAt;
        this.participants = participants;
    }

    public Collection<GHLabel> getLabels() {
        return labels;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    // TODO Return List<GHUser> or List<CustomDTO>
    public List<String> getParticipants() throws IOException {
        List<String> participantNames = new ArrayList<>();
        for (GHUser participant : this.participants) {
            participantNames.add(participant.getName());
        }

        return participantNames;
    }
}
