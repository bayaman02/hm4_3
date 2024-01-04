package com.classwork.hm4_3.countries;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.classwork.hm4_3.R;
import com.classwork.hm4_3.databinding.FragmentContriesBinding;

import java.util.ArrayList;

public class ContriesFragment extends Fragment {

    private ArrayList<CountryModel> countryList = new ArrayList<>();
    private FragmentContriesBinding binding;
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContriesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        position = getArguments().getInt("key");
        checkPosition(position);
        CountriesAdapter adapter = new CountriesAdapter(countryList);
        binding.rvCountries.setAdapter(adapter);
    }

    private void checkPosition(int position) {
        if (position == 0){
            loadEurope();
        } else if (position == 1) {
            loadAsia();
        }
    }

    private void loadEurope() {
        countryList.add(new CountryModel("Portugal", "https://flagshub.com/images/flag-of-portugal.png"));
        countryList.add(new CountryModel("Ispania", "data:image/png;base64,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"));
        countryList.add(new CountryModel("France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAFVBMVEX///8AJlTOESYAGU16gpXefILNABnwlnA6AAAA/klEQVR4nO3QSQ0AIAADsHH6l4yKPUhaCc2oWTs9586aOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHy4ckD5KrN4eD2boIAAAAASUVORK5CYII="));
        countryList.add(new CountryModel("Poland", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARwAAACxCAMAAAAh3/JWAAAADFBMVEX////cFDzup6/bAC47xqeuAAAA0UlEQVR4nO3QMQHAMAzAsLTjz3kI4qO3BEEzAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPLms5mM1h5WcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICf8zMtmEUHJBe8AAAAASUVORK5CYII="));
        countryList.add(new CountryModel("Turkey", "data:image/png;base64,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"));
    }
    private void loadAsia(){
        countryList.add(new CountryModel("Kyrgyzstan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-jpJC24EJigxjs9O0aplzQykQrmJNdu9G5A&usqp=CAU"));
        countryList.add(new CountryModel("Kazakhstan", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAT4AAACfCAMAAABX0UX9AAAA/1BMVEUAq8L/7C0AqcUAqsMAqMcAp8gAqcT/7Sr/7iP/7iX/7x8Aq8H/8RUApsn/8BsAqMgArL4ApcwArbz56yzM3Vefz3qWzIDx6TT36jTu5zrW4E5JuKgwtK+x1Wvq5j5swpKEx4rG213/8wAgsLbe40Z6xJKPyoTT4FBov5q412igz3u62GGXzX50wpai0XIqsrMAodFPuqSv1G5avpun025OuabY4kYzsLpuxI5/xoyv0nee0HSAyYNUvpl2w5RfwJfv5kS42lkntqey12TO3F3S4kGXyopkvKOJy4Hm5zRwv597xoufzYC42VxSvpYAsbHD3U/H30em1mBRt67c4Fj1WfxqAAAU5UlEQVR4nO1dC3ebSLKG7oZ+AC0ESDyFhEEvyxKDsOXIztjZOBvH8WQyu9n//1tuIz/zmBn73BOQ5+g7ZxTbiUetoqrrq+qqaknaYYcddthhhx12+AcANr2AF4UcAkkCKgQIquIrCPOd/J4OtbSPALxcXS26V9kQwDzugqbX9JKAVrapuTTmPMY0goFnNb2iFwU00ktoe+3irO3Q8FifKk2v6EUB9PkrK6ERAKYbSyU7QE2v6EUBrBm2Sr2LwEQfwYwtduJ7DtAJsV8psSupY9sqXOrsjPc5UAPsnUwG+lmkL8OTGPvWjrg8HdBi2MvYqRf08CmPfUwvd+J7OtSSx1bU95YUB+86ae7wwY73PR1gqJ+eBz3/nJGDxJntv9JPd77j6QB9fbG2vbJkZBT57slrfcdcngFoUbv4ta05hMZp+22RkaPd3vcMgBKTceLrzpLb78Y2He2U7zmAHR9jHI80MMwwlr3lLuZ9DjQHy9gerwGYvPPEl0G6M95nAIQYB47MpyMdjx0Z91tNr+hFQXPJ+m07jyn2wvbnvm1HO+17OtRSdyI7KATv6+Zjd3iij3a0+ekAfX4xdBP/LSPDJFidfOA73vcMwIL7Whl6fUZO360jEbStd9r3DJgEByf+qSP78cBevqN4R5ufA3WM5fGo0IXnHQwdD/tm0yt6UUAnBIdth4SWHYN0ly59JsCAuemR7iioo6+11fYl67d7LwF9dp4mrABaSmNr4m6R490IDuaPvtk+gL4eRjxod3qtJT8z2Ral+36vOADY3/D442I75YeWNpzxSUTsec4yGARbs/eBf1fHLupqWFWRjN5XsoRa04v6BjC/usx5ZhxQe9auxJiVzT9m8LoKvIHbQRK0+IV4oKbbFVYBj8/Vptf2NWCYG1N+1p5Qu9sOedA63gLep/y7qDSO2qYESu4jCaw3ZwhgtnWcHoKcxWDec93ZWk3YBDQrPVi9vTKzhd0CRkao4lUR1DJ2iCQ00C8r7Wv++T4CWvL1eo/LMttbhnzc7OMFr46FcNA+d4TdcuyqYIzJmTJh9KIFQrxJB6Fyi5JCMCWuVh6NKF4eTaQxuWxUfqCMUyCBM8ZGiqbLZAKuMDlQEkxniplR3xLSW2db5EDQgo8QBJqNQwTARHeaJS7I9iIE33KZ5Ihh/r7lcH2urig7NPYZzhQIunpne7hVddJmQvGHEJ/4Q81I0ZT6qZVJoiWzC6QK8e0bXd9J4fHrCQRncRaZV5j2FLhg1UKFnja0yq+BOnw/et0CFsEFQOeTuZ409GxBX6idYAIM08L4xPUhAKlwJBBUTtgygTbm7FJIFwfCfajq+VYUEWu2bE3HXyKL0SL/Ml1pGW5oY4a53bGApMQY28j6MFErNwxQBaBWcjy+nqBzoZYDBFHozLaBAaqlPusQomMHy46tMzo70Jsqcmkd6PEcoQHHuiZ0DgLFDD9+OF0uOoPLXEVClgCMOHVTZJ1ieyuUDwz092aSFQ6RZRqXSXZc6odN7cwwpiSxwCwWYRpE5mQWY0YopYQxL+t8EVYMrWk2VyYxYd2tcB9CfPvtow/tQSW+w1/Oh+1+I+IDFVsHJZNJpqomkJA1ignF8j0wwU4JIFRNpSQYZ8LdiW2xaQ2Eoe5GbdUKaJwQPwVGmvFh/cYLX00sRex7MyLvpZW7OPPZI9ndSTCJUMW0hHMRkgQoGjTOn4HDvdkiZvQyd5m77Pk8a6BKA1qZ27uUWmbAe4I1W8n3wqtA7YFQwCgmXUVJ12N60LT0JGj2PCIM4wiBfGYTYieN7Mkw9RmNR9AU7w4in/xIeBsF7EEIrRxFU4/xwy3gfig9jN1/FYYI1KMLP74Im8n3gcjDmM8E8wOh/UPVuwFJNOGCI49gNm1c96rt2uaccdqD4ABzxjgeNOPT0JGN8ZWw3OivpCfkJwgfKHWZCTk2stCvYNps+uX4gLLFkNHDPD8l+Evdy7IUBQHYOorpGYCm/5fSE/ITIa+Z0KkpaCBS1Ebr6cC57hgwNE6IHVPHiCzlsPYqDbWfJafDy9wwj4XzTehfS084kAmAWorU6OOoFzSzVd8BjPT37UHvl1HF+y5+GfTapd6r23pB4XJGPadKkZ6xv5OejOPqH05imzB92mwXCnild+auPJYr8eHAs7v9BkrrQVoxFT4Ckub9jenemG9LMjMqY7xWG86NR3pWvMHjZE7w66njecMpnzRAm8GAMr0EaPT3yifUz82hmnC2ChuP3EDAwlEPIZPRQkGvZ1YjXVkQKnlnLVyq+wTlE+p3gGDaWWsANu18N/nlUFDRqrQKRuZCrzsYVxVgpvlnqy1Iy+QpyifUL9MkqBhpnlqaghoVoZqREIjgY5NtBqnt1VwaDs8z2fNs2z5QRcz7t273BvQSwjSwbU/85kWjteygrycGMiyMCwOhg/oPEqDVdVlV3S9JLe9p0qusFwy5jCkflw2fW8KYRAsnxrKbfLJcu/5nCZE5iDkfqzD6s1j3O+v9nwJDESMlhdp03AuGei/1ddnmdjHQF030JUAkldcpBJMniy82JVhc56Bp4VVL93EKC9fra1ps56gJ2oIMow0l9P6p4pMFdZGUttGw3xBLLw8MoXPtLrFn7bW+bA+v65UfREY6WazkLIVo/8nisyMI1p6bjApJaVQD1WyKXNu8JvYCZTgf2fXSPpiexoSRTcyBDp/oeIX1hqqWUYzFbzpnTRYdoBHPR/oB9N18ok8lt+45Llran2acEf0coMWTxWd/garDCafj/aLZnEufR9D2tLBEAY00WntxbjU9Kz3/bS72vt+ebLxeJIjfaFSYasO7H+izT1FXHymo1Gfav7xaeB/45kNDpV0FHesne14/rVxH+5ttT63/6FxE6V4kIl0JOCRMM9argbmACS8ff3KE5o57BtTiyeLLVGh+8g8j5fFjULNx7dsgmlL7d2NfH4Z60n7r4qwG8aEef5RURHDgM4zdKvB+ovjoVAFzjilJjh4ECCObH9dtyvAKM90ucDYj55nOsFdD+hZNSWZK6MZJWaOqOISyKygZ2ZMSLrLMhlUtXVV/oAc3c2eAIpgMY3WLD6acXqeLYF8wgJPkc2mzjz+fR6FTQnLl1KlMDZaD97+d9KYn4rGhgydar/AckjrvTZcnv42uU/F/AdduasyoXbf4wDkfo8O3+FdGXo/Xr8ITXsMsCDBk7Lr9Rt8o+m0VlQghIPz8xISV05JAq21sqq82T1uZ6SX08aruhjzBW3qn+l4SMTbf39OdD/xnu17UAvCI0pnxhvfvFV1VFyw2oeE8LV06AWDI4/KBosI3/DzEdIYgqrXwBUa6byZzo0No0i57ocPnP9d4QcIHyIxxrGZsefekWlHMZDYScn1Ssr7yu5kIOZZ3Rx3wi82KgVDpVhrrYZ3yQ1MWvE07DMds+jma8eAnvzlyKCvbPcoih8a3tmYMhOelexMgGX9/TimUT7Ae6HAhvyy/eQBgwHg+xvQYrGi94qtO9RljuMhdzhjF5z+ZuMCCYtcS1ntySvlNo5qW7OlktSwUJDzZ36sfmbUkKNjOpyuu62cbW2mNqVvYwn46jCa1cmdrT2w3+A9LQei/1Vf6z+69a80omRkBdUeEbqwXDteFZSioPf9Nk1Cf/53p+hYER7/lhmKgz+Wo0jXB+PD4UDyNkMis3qK1urWvqmHGbD5hOLCFGm6K5DcnZsaU8wRJRu+v9Q/jEMCcMlpUTW6bskpBeBjOPBxoMWY1HzZ8tfd9nv70vU+FYqeT7aia+CSzh3okY8lk7ApTNJK/kh8mE1QdD27EePe7whPJWOZlj+AYojozbl953snP97woYEeGQ3F2XfkIfN8gZAgFYkI0SMQesz+XH6YTpUo4zDjFdnS7UrSufgGPXwvTDVvOXo2tvxXvW+i688D7fm7GSvA1HFoupuO4Ege72fql1rXOsoFmXC4FlTYO+J/QP+qGSFKH+5YRHXrcvT3WEjZbie8PLLiPkfBVjdr3VdQxrCHqEJsFDgsqV25KmJxf1XhLaunuRwYAhYh+hT4qhfuj6A2zmQWqoy2WaQCByWy1yZTeVXZgmSQoYbX2pWxi3s+3Me+7GmJeqK2IHVYVXcSfCWu7KWqIbg59XCzvpaoQEehQgr8VXlYaVaPMqWDYHaXKEpj55hPclRXhzEwYn9TqOzYZF2+Tcfm1lowLTH1Ky0M+NcP2Na3m5Eu3LbrKgmD+QcnPxQNEWtcnBN8JhhLiTFpCrvk5tDJBsh+4MZqSjeoJTX7rsDpC9sfY5Pvadeb7QORScurwEklKKTbBO5oLxf4bF0bO9RXanMCF3T/EJimAs+kwNarrMI6YnrTUA8qcOxtBcyJTYsfCbb+Oae0z46tsc/4o23zx89OlIBL6F8uV11VKeq8vSsC6AChTKu9ZoGp5gUgxzM9RlKpGS3wLoCoInkyPgJI7+i1BgKl4Fr23xi8JjUUUV3uzUQNnHVDJY3ob3ygDcpu4B/MkFY9OE/th0v545aRw0zUEYcWpAZDU+ZVjCcpNe4oEWxNn4zagNGZ+oUAonLnYHQdG3Ye+9Z+0wXxgaQELLqo9TlJ6zM43Q0aiFrxJBTrAcDE7UaxrwYyFzkFJ658DISA+MkRkuylABGaVJZXQUh8Lbyy1Drhw5JP2Wd0tUQ2c84ogYa1NM3jzoGDA4vTefRhjEbnBVBcBibHi+iU6uxqnYKbrQzXAOFFQ6D4i9uhAdyrlhEX8SY6jKNirux30tspgXWOVAYx8PZ7Kzk1jhti9SHb3ptDaWypVbyCOARQyfI+uKO+CFaYXxiXDb6q+Dz+5e8Li0Qcb3ijlxhc6dhgLaj5qa6TGBaQOozIb35xMgIIK+d28KxgdGOL1PSMR0LgsXjNM3hsnhM4UtGBV7SawkttoQ3i9u8BDlRwsPEdQe2FxIxVWEKxdFpe3n10ZEhLfBLCw6pmsdrRBSwIcOwaYUXqJckJ7SJg53aSnrM22B9UOI/PbnToNmIzJYQO1zpv6Prfu+j5kjrwsvH1WyppSr9hI4oY/j5NKBwkrABgw2YJgxhdCfDl9CImAOWPkjv0Jb+SxrGiiHW9TXZrUXl1qAm2Yzcqbb5TCZ7x736Sh/Kd6BXZmVBmhlVG1HVeECs3vx/qiKONkdRveQpQn+KCRQtOb2mbFwvioztpm7eIqSMYsu5UYMEe+Pr49uRAy22RRr6oOE2hXKwLOCNz/RZU0HFAW3A2MgmaH2oV1XMvCv0FTlfXa8JPvYff6zlUi9XJJRtptLLF5+W8lTTDbCLG4YSQ3f4G+jPXVBNxb7koEwVxfNFBr1VxfB1AMq/SDh8J4YBzZ8Rw+mODmQYKzTXihpXc/hShd8uxeeMINRRmz407URItR1VXUbaarKJ1mnDvRo8IAkMZ6dmZ+Xb32FZODQI2WzJ8/1ITDdEbiUQgbqfNrsqcNWpfz01i/0B7/KGNMKJKEfkRBIABW/x3jh9rDCqEy4Vi+yg4aqdCtOirPHndUjursqERrx7Mj5ZGooDlmmLBgP7RUBG7SBZu0AUDAzK8Tl1F7+KioDx6vM+/NdPClmfrwZvt5YdjJ3LgTpo9+BKeEYkq4++7kVZgeW5b40fHxl/ODJKvOUTGePGZ3ykJnznXRVF/qbTd5+6GbfFlnNzlEKPwvsfuPP71S9N64NqZc13VuX/2hmDOXccYYIYx62fDx6o7DqRv0OvPGJp2bNps9mmUQLWqeZWCduvz66+Yg2EJpdHT5cdhNPMbWWsAoo+6boNedH6VfxZRgvbcvtVEDnTz3K7ifpIGamaSBzHkQTL7xttWmVw16SDuxNuaeM7rMJaWFvunfhWjEbKfWiqDvUM1x8Rud4wLQ0Ww8ytUfFOZBZCX6NDV+2PeMUrFN2otG+1HvpwgBECVNTRGCSjoaT+cp+NYFQLWnD5QfLQgic+jrOIma7euoZlhNb2ZYecw/3MywamBB1UCv0WGnzL9qEQLajE1+ZA3QjEYxixdhw00xWzJBbbMUgLQwzB/oL0Bhlv0wFDOL14vO/IvWanyUQTW/r2h+ft8tHrY4YZyXid39E0JXlZM3PrxP+sH0yLTB6ZGPgKLTmM/S76UHUau1qae/i0gaRTW79GBLZpc+Auhy21m/6n034R9Ey+l0uvhwXX7JU6v5e4E0G2/J5NxHAJHdWx8SvvpuSJo1ZXQzzZQz24+njdvJ9sxtfgAMs3i6wJh02hYEqvqIEf5xV7jmisCYN38j3xZNDb+HckWZTlw/np3Mlq9+//X3fgRvhjgX7k0hn0xeD7Ks2/RCpa2bWb9Z0sWkc1ntbWJzg5pppVGKVM2K5rNNwRqOPco/KqrU/Ervbky4rG5MuGz+xoTbNQGkVp5VkJcPvXf/qxBksc2okJ2NcRQls625RXir7uv4CugsrlpVsdgFq/9k8YK9Ce0hiLZB8TbYsttiHgGMdNYTsdArRroOyV5zXCb2XImapysP2Mq7im5gutnEmNlH53sLsMIT890cmTnYrqt2vr8p63Jb1qflGhBPF+UfIcxzAKt5N9uytnts7z1tG1lVN03Ax8HwluHulsD97bsl8CVgi++ofAnY+htStxu7+3n/X6huhw7uboce726Hfia+upv8ZHc3+fMAC+5rZej1GTl9t47yd3zrbtHcZoA+vxi6if+WkWESrE5+dj/vPwxqqY8jOygmIrDMx+7wRG8+B/mSoPlk8LadxxR7R+3PfdluPlf/kgBCjAPH5r2RjseOjPtNTB5+udCcamL3eA3Q5J0nvlw1WjPy4gA7PsY4HmlgXc0G8ZZbk8d9EQBVQ3fi686S28nYpjU3s79wQIvYxa9tzSE0ttpvi4zsaPMzAPr6Ym17ZcnIKPLdk9f6jvc9A2Con54HPf+ckYPEme2/auCqohcMteSxFfW9JcXBu06aO3wLSlxeDqDFsJfxUy9Y4lMe+5jWOAHqHwA1wN5JOdDnkb4MT+JGbnp6wUAnxO4rsSupjm0Vu3TpMwHWDFul3kVgoo9gtkvWPw+gz19ZCY0AMN1YKmufYvTCgUZ6CW2vXZy1HRoe63Xf1/HCgVa2qbk05jyuppkF3s51PANqaYdAvVxdLbpX2RDAPOvueN8zkFfd70CtSuqqURQQNnrh7cvHTno77LDDDjvssMMO/xz8H40HHhB/jUoEAAAAAElFTkSuQmCC"));
        countryList.add(new CountryModel("Uzbekistan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRH875l_lS_5RwQWm0xxVSez-2ylpV-eP54ZnnAqdFMmzgxQKVNa_RZFdwzH6NksKzk7MU&usqp=CAU"));
        countryList.add(new CountryModel("Tajikistan", "data:image/png;base64,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"));
        countryList.add(new CountryModel("China", "data:image/png;base64,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"));
    }
}