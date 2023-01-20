//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

public class Programme {
    public String programmeId;
    public String programmeName;

    public Programme(String programmeId, String programmeName) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
    }

    public String toString() {
        return "Programme [programmeId=" + this.programmeId + ", programmeName=" + this.programmeName;
    }

    public String getProgrammeId() {
        return this.programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return this.programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }
}
