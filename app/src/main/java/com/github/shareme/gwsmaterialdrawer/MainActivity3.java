/*
 * Copyright 2015 Heinrich Reimer
 * Modifications Copyright(C) 2015 Fred Grott(GrottWorkShop)
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

package com.github.shareme.gwsmaterialdrawer;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.shareme.gwsmaterialdrawer.library.DrawerActivity;
import com.github.shareme.gwsmaterialdrawer.library.structure.DrawerFragmentItem;
import com.github.shareme.gwsmaterialdrawer.library.structure.DrawerItem;
import com.github.shareme.gwsmaterialdrawer.library.structure.DrawerProfile;
import com.github.shareme.gwsmaterialdrawer.library.theme.DrawerTheme;




public class MainActivity3 extends DrawerActivity {

    @SuppressWarnings("deprecation")
    @SuppressLint("PrivateResource")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        setDrawerTheme(
                new DrawerTheme(this)
                        .setBackgroundColorRes(R.color.background_material_dark)
                        .setTextColorPrimaryRes(R.color.primary_text_default_material_dark)
                        .setTextColorSecondaryRes(R.color.secondary_text_default_material_dark)
        );

        addItems(new DrawerItem()
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
                        .setDrawerTheme(
                                //TODO: change to using GWSColours to get around grey being marked private
                                new DrawerTheme(getDrawerTheme())
                                        .setBackgroundColorRes(R.color.material_blue_grey_800)
                        ),
                new DrawerFragmentItem()
                        .setFragment(new ListFragment())
                        .setTextPrimary(getString(R.string.lorem_ipsum_medium)),
                new DrawerFragmentItem()
                        .setFragment(new Fragment())
                        .setImage(getResources().getDrawable(R.mipmap.ic_flag))
                        .setTextPrimary(getString(R.string.lorem_ipsum_short))
                        .setTextSecondary(getString(R.string.lorem_ipsum_long))
        );
        setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                selectItem(position);
                Toast.makeText(MainActivity3.this, "Clicked item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        addProfile(new DrawerProfile()
                        .setId(1)
                        .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_1))
                        .setName(getString(R.string.lorem_ipsum_short))
        );
        addProfile(new DrawerProfile()
                        .setId(2)
                        .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.cat_1))
                        .setBackground(getResources().getDrawable(R.drawable.cat_wide_2))
                        .setName(getString(R.string.lorem_ipsum_short))
                        .setDescription(getString(R.string.lorem_ipsum_medium))
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_github:
                String url = "https://github.com/HeinrichReimer/material-drawer";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
