package spm.db.utils;

import spm.db.models.StorageGroup;
import spm.db.models.StorageGroupStatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kokoster on 10/04/2017.
 */
public class OutlierDetectorTest {
    @org.junit.Test
    public void testSearchOutliersEven() throws Exception {
        List<StorageGroupStatistics> storageGroupStatistics =
                new ArrayList<>();

        storageGroupStatistics.add(createStorageGroupStatistics(1, 12));
        storageGroupStatistics.add(createStorageGroupStatistics(2, 1));
        storageGroupStatistics.add(createStorageGroupStatistics(3, 140));
        storageGroupStatistics.add(createStorageGroupStatistics(4, 30));
        storageGroupStatistics.add(createStorageGroupStatistics(5, 2));
        storageGroupStatistics.add(createStorageGroupStatistics(6, 110));

        OutlierDetector outlierDetector = new OutlierDetector();
        List<StorageGroup> outlierStorageGroups = outlierDetector.searchOutliers(storageGroupStatistics);
        List<StorageGroup> expectedOutlierStorageGroups =
                new ArrayList<>(Arrays.asList(new StorageGroup(3), new StorageGroup(6)));

        assertEquals(outlierStorageGroups, expectedOutlierStorageGroups);
    }

    @org.junit.Test
    public void testSearchOutliersOdd() throws Exception {
        List<StorageGroupStatistics> storageGroupStatistics =
                new ArrayList<>();

        storageGroupStatistics.add(createStorageGroupStatistics(1, 12));
        storageGroupStatistics.add(createStorageGroupStatistics(2, 1));
        storageGroupStatistics.add(createStorageGroupStatistics(3, 140));
        storageGroupStatistics.add(createStorageGroupStatistics(4, 10));
        storageGroupStatistics.add(createStorageGroupStatistics(5, 2));
        storageGroupStatistics.add(createStorageGroupStatistics(6, 5));
        storageGroupStatistics.add(createStorageGroupStatistics(3, 1));

        OutlierDetector outlierDetector = new OutlierDetector();
        List<StorageGroup> outlierStorageGroups = outlierDetector.searchOutliers(storageGroupStatistics);
        List<StorageGroup> expectedOutlierStorageGroups =
                new ArrayList<>(Arrays.asList(new StorageGroup(3)));

        assertEquals(expectedOutlierStorageGroups, outlierStorageGroups);
    }

    @org.junit.Test
    public void testOneElement() throws Exception {
        List<StorageGroupStatistics> storageGroupStatistics =
             new ArrayList<>(Arrays.asList(createStorageGroupStatistics(1, 10)));

        OutlierDetector outlierDetector = new OutlierDetector();
        List<StorageGroup> outlierStorageGroups = outlierDetector.searchOutliers(storageGroupStatistics);
        List<StorageGroup> expectedOutlierStorageGroups =
                new ArrayList<>(Arrays.asList(new StorageGroup(1)));

        assertEquals(expectedOutlierStorageGroups, outlierStorageGroups);
    }

    @org.junit.Test
    public void testTwoElements() throws Exception {
        List<StorageGroupStatistics> storageGroupStatistics =
                new ArrayList<>(Arrays.asList(createStorageGroupStatistics(1, 10),
                                              createStorageGroupStatistics(2, 1500)));

        OutlierDetector outlierDetector = new OutlierDetector();
        List<StorageGroup> outlierStorageGroups = outlierDetector.searchOutliers(storageGroupStatistics);
        List<StorageGroup> expectedOutlierStorageGroups =
                new ArrayList<>(Arrays.asList(new StorageGroup(2)));

        assertEquals(expectedOutlierStorageGroups, outlierStorageGroups);
    }

    @org.junit.Test
    public void testEqualElements() throws Exception {
        List<StorageGroupStatistics> storageGroupStatistics =
                new ArrayList<>(Arrays.asList(createStorageGroupStatistics(1, 10),
                                              createStorageGroupStatistics(2, 10),
                                              createStorageGroupStatistics(3, 10)));

        OutlierDetector outlierDetector = new OutlierDetector();
        List<StorageGroup> outlierStorageGroups = outlierDetector.searchOutliers(storageGroupStatistics);
        List<StorageGroup> expectedOutlierStorageGroups =
                new ArrayList<>(Arrays.asList(new StorageGroup(1), new StorageGroup(2), new StorageGroup(3)));

        assertEquals(expectedOutlierStorageGroups, outlierStorageGroups);
    }

    private StorageGroupStatistics createStorageGroupStatistics(int storageGroupID, float queriesCount) {
        return new StorageGroupStatistics(new StorageGroup(storageGroupID), queriesCount);
    }
}