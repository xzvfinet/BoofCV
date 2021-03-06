/*
 * Copyright (c) 2011-2017, Peter Abeles. All Rights Reserved.
 *
 * This file is part of BoofCV (http://boofcv.org).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package boofcv.alg.geo;

import org.ddogleg.fitting.modelset.DistanceFromModel;

/**
 * Compute the distance between a model and an observation for a single camera in pixels
 * when the observations are in normalized image coordinates.
 *
 * @author Peter Abeles
 */
public interface DistanceModelMonoPixels<Model,Point> extends DistanceFromModel<Model,Point>
{

	/**
	 * Specifies intrinsic camera parameters.
	 *
	 * @param fx focal length x-axis
	 * @param fy focal length y-axis
	 * @param skew skew
	 */
	public void setIntrinsic( double fx, double fy, double skew );
}
