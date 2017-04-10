package spm.db.utils;

import spm.db.models.StorageGroup;
import spm.db.models.StorageGroupStatistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Searches storagegroups with anomaly queries count.
 * If queries counts are equal for several anomaly storagegroups, returns all of them
 */
public class OutlierDetector {
    public List<StorageGroup> searchOutliers(List<StorageGroupStatistics> storageGroupStatistics) {
        int size = storageGroupStatistics.size();

        float upperOuterFence;
        if (size < 3) {
            upperOuterFence = findMedianValue(storageGroupStatistics, 0, size);
        } else {
            float lowerQuartile = findMedianValue(storageGroupStatistics, 0, (size - 1) / 2);

            int upperStartIndex = (size - 1) / 2 + 1;
            if (size % 2 != 0) {
                upperStartIndex = size / 2 + 1;
            }

            float upperQuartile = findMedianValue(storageGroupStatistics, upperStartIndex, (size - 1) / 2);

            float interQuartile = upperQuartile - lowerQuartile;
            upperOuterFence = upperQuartile + 3 * interQuartile;
        }

        List<StorageGroup> storageGroups = new ArrayList<>();
        for (Object statistics : storageGroupStatistics) {
            if (((StorageGroupStatistics) statistics).getQueriesCount() >= upperOuterFence) {
                storageGroups.add(((StorageGroupStatistics) statistics).getStorageGroup());
            }
        }

        return storageGroups;
    }

    private float findMedianValue(List<StorageGroupStatistics> storageGroupStatistics, int startIndex, int size) {
        float median = (storageGroupStatistics.get(startIndex + (size - 1) / 2))
                .getQueriesCount();

        if (size % 2 == 0) {
            float median2 = (storageGroupStatistics.get(startIndex + size / 2))
                    .getQueriesCount();

            median = (median + median2) / 2;
        }

        return median;
    }
}
