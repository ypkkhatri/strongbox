package org.carlspring.strongbox.services;

import org.carlspring.strongbox.storage.metadata.MetadataType;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.metadata.Metadata;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * @author stodorov
 */
public interface ArtifactMetadataService extends ConfigurationService
{

    /**
     * Get artifact metadata using artifactPath(string) instead of Artifact.
     *
     * @param storageId     String
     * @param repositoryId  String
     * @param artifactPath  String
     *
     * @return Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    Metadata getMetadata(String storageId, String repositoryId, String artifactPath)
            throws IOException, XmlPullParserException;

    /**
     * Get artifact metadata.
     *
     * @param artifactBasePath  The base path of the artifact
     *
     * @return Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    Metadata getMetadata(String artifactBasePath)
            throws IOException, XmlPullParserException;

    /**
     * Get artifact metadata using an InputStream.
     *
     * @return Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    Metadata getMetadata(InputStream is)
            throws IOException, XmlPullParserException;

    /**
     * Rebuild metadata for artifact using artifactPath (string)
     *
     * @param storageId     String
     * @param repositoryId  String
     * @param artifactPath  String
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    void rebuildMetadata(String storageId, String repositoryId, String artifactPath)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

    /**
     * Merge existing artifact metadata with mergeMetadata.
     *
     * @param storageId     String
     * @param repositoryId  String
     * @param artifact      Artifact
     * @param mergeMetadata Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    void mergeMetadata(String storageId, String repositoryId, Artifact artifact, Metadata mergeMetadata)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

    /**
     * Add a version to a metadata and store it to a file.
     *
     * @param storageId
     * @param repositoryId
     * @param artifactPath
     * @param version
     * @param metadataType
     * @throws IOException
     * @throws XmlPullParserException
     * @throws NoSuchAlgorithmException
     */
    void addVersion(String storageId,
                    String repositoryId,
                    String artifactPath,
                    String version,
                    MetadataType metadataType)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

    /**
     * Add a version to a metadata object.
     *
     * @param metadata
     * @param version
     * @throws IOException
     * @throws XmlPullParserException
     * @throws NoSuchAlgorithmException
     */
    void addVersion(Metadata metadata, String version);

    /**
     * Adds a timestamped SNAPSHOT version to a SNAPSHOT metadata and stores it to a file.
     *
     * @param storageId
     * @param repositoryId
     * @param artifactPath
     * @param version
     * @param classifier
     * @param extension
     * @throws IOException
     * @throws XmlPullParserException
     * @throws NoSuchAlgorithmException
     */
    void addTimestampedSnapshotVersion(String storageId,
                                       String repositoryId,
                                       String artifactPath,
                                       String version,
                                       String classifier,
                                       String extension)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

    /**
     * Adds a timestamped SNAPSHOT version to a SNAPSHOT to a metadata object.
     *
     * @param metadata
     * @param version
     * @param classifier
     * @param extension
     * @throws IOException
     * @throws XmlPullParserException
     * @throws NoSuchAlgorithmException
     */
    void addTimestampedSnapshotVersion(Metadata metadata,
                                       String version,
                                       String classifier,
                                       String extension);

    /**
     * Removes an existing version from the metadata file.
     *
     * @param storageId
     * @param repositoryId
     * @param artifactPath
     * @param version
     * @param metadataType
     * @throws IOException
     * @throws XmlPullParserException
     * @throws NoSuchAlgorithmException
     */
    void removeVersion(String storageId,
                       String repositoryId,
                       String artifactPath,
                       String version,
                       MetadataType metadataType)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

    /**
     * Removes an existing timestamped SNAPSHOT version from the SNAPSHOT metadata file.
     *
     * @param storageId
     * @param repositoryId
     * @param artifactPath
     * @param version
     * @param classifier
     * @throws IOException
     * @throws XmlPullParserException
     * @throws NoSuchAlgorithmException
     */
    void removeTimestampedSnapshotVersion(String storageId,
                                          String repositoryId,
                                          String artifactPath,
                                          String version,
                                          String classifier)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

}
