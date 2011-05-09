/*
 * Copyright 2011 Peter Abeles
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package gecv.abst.detect.extract;

import gecv.struct.QueueCorner;
import gecv.struct.image.ImageFloat32;


/**
 * <p>
 * Extracts corner features from an intensity image.  The intensity image indicates the location of features
 * across the image based the intensity value.  Typically local maximums are considered to be the location of
 * features.
 * </p>
 *
 * <p>
 * There are many different ways in which features can be extracted.  Depending on the application having features
 * spread across the whole image can be more advantageous than simply selecting the features with the highest
 * intensity.
 * </p>
 *
 * <p>
 * Depending in the implementation the following may or may not be supported:
 * <ul>
 * <li> Ignore existing corners.  Corners which are passed in will be ignored. </li>
 * <li> Return the specified number of features, always. </li>
 * </ul>
 *
 * @author Peter Abeles
 */
public interface CornerExtractor {

	/**
	 * Process a feature intensity image to extract the point features.
	 *
	 * @param intensity	Feature intensity image.  Can be modified.
	 * @param foundCorners	List of existing features (not always supported) and where new features are stored.
	 * @param requestedNumber Number of features it should find.  Not always supported.
	 */
	public void process(ImageFloat32 intensity, QueueCorner candidate, int requestedNumber , QueueCorner foundCorners);

	/**
	 * If it requires a list of candidate corners.
	 *
	 * @return true if candidates are required.
	 */
	public boolean getUsesCandidates();

	/**
	 * Returns if features passed in with the corners list are ignored or not.
	 * @return If previously found features are ignored or not.
	 */
	public boolean getIgnoreExistingCorners();

	/**
	 * If it accepts requests to find a specific number of features or not.
	 * @return If requests are accepted for number of features.
	 */
	public boolean getAcceptRequest();
}