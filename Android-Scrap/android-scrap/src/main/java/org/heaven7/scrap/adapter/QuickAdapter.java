/*
 * Copyright (C) 2015
 *            heaven7(donshine723@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.heaven7.scrap.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction class of a BaseAdapter in which you only need to provide the
 * convert() implementation.<br/>
 * Using the provided BaseAdapterHelper, your code is minimalist.
 * 
 * @param <T>
 *            The type of the items in the list.
 */
public abstract class QuickAdapter<T> extends
		BaseQuickAdapter<T, BaseAdapterHelper> {
	
	/**
	 * Create a QuickAdapter.
	 * 
	 * @param layoutResId
	 *            The layout resource id of each item.
	 */
	public QuickAdapter(int layoutResId) {
		super(layoutResId);
	}

	/**
	 * Same as QuickAdapter#QuickAdapter(Context,int) but with some
	 * initialization data.
	 * 
	 * @param layoutResId
	 *            The layout resource id of each item.
	 * @param data
	 *            A new list is created out of this one to avoid mutable list
	 */
	public QuickAdapter(int layoutResId, List<T> data) {
		super( layoutResId, data);
	}

	public QuickAdapter(ArrayList<T> data,
			MultiItemTypeSupport<T> multiItemSupport) {
		super(data, multiItemSupport);
	}

	@Override
	protected BaseAdapterHelper getAdapterHelper(int position,
			View convertView, ViewGroup parent) {

		if (mMultiItemSupport != null) {
			return BaseAdapterHelper.get(
					convertView,
					parent,
					mMultiItemSupport.getLayoutId(position, data.get(position)),
					position);
		} else {
			return BaseAdapterHelper.get(convertView, parent, layoutResId, position);
		}
	}

}
